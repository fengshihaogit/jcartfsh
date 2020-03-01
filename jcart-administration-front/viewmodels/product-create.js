var app = new Vue({
    el: '#app',
    data: {
        productCode: '',
        productName: '',
        price: '',
        discount: '',
        stockQuantity: '',
        rewordPoints: '',
        sortOrder: '',
        description: '',
        selectedStatus: 1,
        selectedMainPic: '',
        mainPicUrl: '',
        selectdOtherPics: [],
        otherPicUrls: [],
        statuses: [{
            value: 0,
            label: '下架'
        }, {
            value: 1,
            label: '上架'
        }, {
            value: 2,
            label: '待审核'
        }],
        mainFileList: [],
        otherFileList: []
    },
    methods: {
        handleCreateClick() {
            console.log('create view')
            this.createProduct();
        },
        handleOnMainChange(val) {
            this.selectedMainPic = val.raw;
        },
        handleUploadMainClick() {
            console.log('upload main pic click');
            this.uploadMainImage();
        },
        uploadMainImage() {
            var formData = new FormData();
            formData.append("image", this.selectedMainPic);

            axios.post('/image/upload', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.mainPicUrl = response.data;
                    alert('上传成功');
                })
                .catch(function (error) {
                    console.log(error);
                    alert('上传失败');
                });
        },
        handleOnOtherChange(file, fileList) {
            console.log('fileList', fileList);
            this.selectdOtherPics = fileList;
        },
        handleOnOtherRemove(file, fileList) {
            console.log('fileList', fileList);
            this.selectdOtherPics = fileList;
        },
        handleUploadOtherClick() {
            console.log("upload other pic clike");
            this.uploadOtherImage();
        },
        uploadOtherImage() {
            this.selectdOtherPics.forEach(pic => {
                var formData = new FormData();
                formData.append("image", pic.raw);

                axios.post('/image/upload', formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                    .then(function (response) {
                        console.log(response);
                        var url = response.data;
                        app.otherPicUrls.push(url);                        
                    })
                    .catch(function (error) {
                        console.log(error);
                        alert('上传失败');
                    });
            });
        },
        createProduct() {
            axios.post('/product/create', {
                productCode: this.productCode,
                productName: this.productName,
                price: this.price,
                discount: this.discount,
                stockQuantity: this.stockQuantity,
                status: this.selectedStatus,
                mainPicUrl: this.mainPicUrl,
                rewordPoints: this.rewordPoints,
                sortOrder: this.sortOrder,
                description: this.description,
                otherPicUrls: this.otherPicUrls
            })
                .then(function (response) {
                    console.log(response);
                    alert("创建成功")
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }

})