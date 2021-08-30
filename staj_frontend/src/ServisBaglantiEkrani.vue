<style>
    [v-cloak]{
        display: none; 
   }
</style>

<template>
    <v-app>
        
        <div>
            <title>Servis Bağlantı Ekranı</title>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">

            <!-- Bootstrap CSS -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet">        
        </div>
    
        <div class="container mt-5" id="servis-baglanti-ekrani" v-cloak>

            <div class="col-md-12">
                <button class="btn btn-sm btn-warning mb-2" v-b-modal.servis-baglanti-kayit-modal>Yeni Kayıt</button>
                <router-link class="btn btn-sm btn-warning mb-2" to="/">Geri Dön</router-link>
                <table class="table">
                    <thead>
                        <tr class="table-dark">
                            <th>Kurum ID</th>
                            <th>Servis Adresi</th>
                            <th>Max Deneme Sayısı</th>
                            <th>TimeOut Süresi (Sn)</th>
                            <th>İşlem</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="baglanti in servisBaglantilar" v-bind:key="baglanti.id">
                            <th>{{baglanti.kurumId}}</th>
                            <td>{{baglanti.servisAdresi}}</td>
                            <td>{{baglanti.maxDenemeSayisi}}</td>
                            <td>{{baglanti.zamanAsimiSuresi}}</td>
                            <td>
                                <button class="btn btn-sm btn-secondary" v-b-modal.servis-baglanti-guncelle-modal @click="servisBaglantiGetir(baglanti.id)">Güncelle</button>                              
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <!-- click "Yeni Kayıt" : Servis Bağlantı Kayıt Modal -->
            <b-modal class="modal fade" id="servis-baglanti-kayit-modal" hide-backdrop no-close-on-backdrop size="lg" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" title="Servis Bağlantı Ekranı" ok-only ok-title="Geri Dön">
                
                <b-row class="mb-3 row">
                    <b-col sm="2">
                        <label for="kurum_id">Kurum ID</label>
                    </b-col>
                    <b-col sm="10">
                        <b-form-textarea id="kurum_id" size="sm" v-model="servis_baglanti.kurum_id"></b-form-textarea>
                    </b-col>
                </b-row>

                <b-row class="mb-3 row">
                    <b-col sm="2">
                        <label for="servis_adresi">Servis Adresi</label>
                    </b-col>
                    <b-col sm="10">
                        <b-form-textarea id="servis_adresi" size="sm" v-model="servis_baglanti.servis_adresi"></b-form-textarea>
                    </b-col>
                </b-row>

                <b-row class="mb-3 row">
                    <b-col sm="2">
                        <label for="max_deneme_sayisi">Max Deneme Sayısı</label>
                    </b-col>
                    <b-col sm="10">
                        <b-form-textarea id="max_deneme_sayisi" size="sm" v-model="servis_baglanti.max_deneme_sayisi"></b-form-textarea>
                    </b-col>
                </b-row>

                <b-row class="mb-3 row">
                    <b-col sm="2">
                        <label for="zaman_asimi_suresi">TimeOut Süresi(Sn)</label>
                    </b-col>
                    <b-col sm="10">
                        <b-form-textarea id="zaman_asimi_suresi" size="sm" v-model="servis_baglanti.zaman_asimi_suresi"></b-form-textarea>
                    </b-col>
                </b-row>

                <div class="mb-3 row">
                  <label class="col-sm-2 col-form-label"></label>
                  <div class="col-sm-10 d-grid">
                    <button class="btn btn-success" @click="servisBaglantiEkle">Kaydet</button>
                  </div>
                </div>                      
                
            </b-modal>

            <!-- click "Güncelle" : Servis Bağlantı Güncelle Modal -->
            <b-modal class="modal fade" id="servis-baglanti-guncelle-modal" hide-backdrop no-close-on-backdrop size="lg" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" title="Servis Bağlantı Güncelleme Ekranı" ok-only ok-title="Geri Dön">
                
                <b-row class="mb-3 row">
                    <b-col sm="2">
                        <label for="kurum_id">Kurum ID</label>
                    </b-col>
                    <b-col sm="10">
                        <b-form-textarea id="kurum_id" size="sm" v-model="servis_baglanti.kurum_id"></b-form-textarea>
                    </b-col>
                </b-row>
                
                <b-row class="mb-3 row">
                    <b-col sm="2">
                        <label for="servis_adresi">Servis Adresi</label>
                    </b-col>
                    <b-col sm="10">
                        <b-form-textarea id="servis_adresi" size="sm" v-model="servis_baglanti.servis_adresi"></b-form-textarea>
                    </b-col>
                </b-row>

                <b-row class="mb-3 row">
                    <b-col sm="2">
                        <label for="max_deneme_sayisi">Max Deneme Sayısı</label>
                    </b-col>
                    <b-col sm="10">
                        <b-form-textarea id="max_deneme_sayisi" size="sm" v-model="servis_baglanti.max_deneme_sayisi"></b-form-textarea>
                    </b-col>
                </b-row>

                <b-row class="mb-3 row">
                    <b-col sm="2">
                        <label for="zaman_asimi_suresi">TimeOut Süresi(Sn)</label>
                    </b-col>
                    <b-col sm="10">
                        <b-form-textarea id="zaman_asimi_suresi" size="sm" v-model="servis_baglanti.zaman_asimi_suresi"></b-form-textarea>
                    </b-col>
                </b-row>

                <b-row class="mb-3 row">
                    <b-col sm="2">
                        <label for="durum-id">Durum</label>
                    </b-col>
                    <b-col sm="10">
                        <b-form-select id="durum-id" style="width: 100%" v-model="servis_baglanti.durum_id" :options="options_durum"></b-form-select>
                    </b-col>
                </b-row>

                <div class="mb-3 row">
                  <label class="col-sm-2 col-form-label"></label>
                  <div class="col-sm-10 d-grid">
                    <button class="btn btn-success" @click="servisBaglantiGuncelle">Güncelle</button>
                  </div>
                </div>

            </b-modal>

        </div>

    </v-app>
</template>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/notify.min.js"></script>
<script src="js/sabitler.js"></script>

<script>
import axios from "axios";
import { BModal, VBModal } from "bootstrap-vue";

const urlParams = new URLSearchParams(window.location.search);

export default {
    el: '#servis-baglanti-ekrani',
    data() {
        return {
            servis_baglanti: {
                kurum_id: "",
                servis_adresi: '',
                max_deneme_sayisi: "",
                zaman_asimi_suresi: "",
                servis_id: "",
                durum_id: 0,
                tanitan_kullanici_id: 1
            },
            servisBaglantiId : this.$router.history.current.params.servisId,
            servisBaglantilar: [],
            options_durum : [0, 1, 2]
        };
    },
    mounted() {
        this.servisBaglantilariGetir();
    },
    methods: {
        servisBaglantiEkle() {
            var thiz = this;
            axios.post('http://localhost:9000/servis-baglanti-kaydet/'+thiz.servisBaglantiId, {
                kurumId: thiz.servis_baglanti.kurum_id,
                servisAdresi: thiz.servis_baglanti.servis_adresi,
                maxDenemeSayisi: thiz.servis_baglanti.max_deneme_sayisi,
                zamanAsimiSuresi: thiz.servis_baglanti.zaman_asimi_suresi,
                durumId: thiz.servis_baglanti.durum_id,
                tanitanKullaniciId: thiz.servis_baglanti.tanitan_kullanici_id
            }).then(response => {
                thiz.servisBaglantilariGetir();                
            })              
        },
        servisBaglantilariGetir() {
            axios.get('http://localhost:9000/servis-baglantilari-getir/'+this.servisBaglantiId)
            .then(response => {
                /*for(let element of response.data)
                this.servisBaglantilar.push(element)*/
                this.servisBaglantilar = response.data;
            })                        
        },
        servisBaglantiGetir(id) {
            axios.get('http://localhost:9000/servis-baglanti-getir/' + id)
            .then(response => {
                this.servis_baglanti = response.data;
            });                        
        },
        servisBaglantiGuncelle() {
            var thiz = this;
            axios.put('http://localhost:9000/servis-baglanti-guncelle/' + thiz.servis_baglanti.id, {
                kurumId: thiz.servis_baglanti.kurum_id,
                servisAdresi: thiz.servis_baglanti.servis_adresi,
                maxDenemeSayisi: thiz.servis_baglanti.max_deneme_sayisi,
                zamanAsimiSuresi: thiz.servis_baglanti.zaman_asimi_suresi,
                durumId: thiz.servis_baglanti.durum_id,
                guncelleyenKullaniciId: thiz.servis_baglanti.tanitan_kullanici_id
            })
            .then(response => {
                this.servisBaglantilariGetir();
            })                        
        }
    }
};
</script>