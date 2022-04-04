<style>
  [v-cloak] {
    display: none;
  }
</style>

<template>
<div> 
    <div>
      <title>Sorgulama Ekranı</title>
      <meta charset="UTF-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />

      <!-- Bootstrap CSS -->
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
    </div>

    <div class="container mt-5" id="sorgulama-ekrani" v-cloak>

      <div class="row">
        <div class="col-md-12">
          <button class="btn btn-sm btn-warning mb-2" data-toggle="modal" v-b-modal.servis-kayit-modal>Yeni Kayıt</button> &nbsp;
          <button class="btn btn-sm btn-warning mb-2" @click="kayitlariGetir">Kayıtları Getir</button>
          <table class="table">
            <thead>
              <tr class="table-dark">
                <th>Servis Adı</th>
                <th>Servis Arayüz Adı</th>
                <th>Sunucu Mu</th>
                <th>Log Durumu</th>
                <th>Durum</th>
                <th>İşlem</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="servis in servisler" v-bind:key="servis.id">
                <th>{{ servis.servisAdi }}</th>
                <td>{{ servis.servisArayuzAdi }}</td>
                <td>{{ servis.sunucuMu }}</td>
                <td>{{ servis.logSeviyesi }}</td>
                <td>{{ servis.durumId }}</td>
                <td>
                  <button class="btn btn-sm btn-success" @click="gecis(servis.id)">Bağlantı Tanımı</button>&nbsp;
                  <button class="btn btn-sm btn-secondary" v-b-modal.servis-guncelle-modal @click="guncelleServisGetir(servis.id)">Güncelle</button>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>

      <!-- click "Yeni Kayıt" : Servis Kayıt Modal -->
      <b-modal class="modal fade" id="servis-kayit-modal" hide-backdrop no-close-on-backdrop size="lg" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" title="Yeni Kayıt Tanım Ekranı" ok-only ok-title="Geri Dön">
        <b-row class="mb-3 row">
          <b-col sm="2">
            <label for="servis-adi">Servis Adı</label>
          </b-col>
          <b-col sm="10">
            <b-form-textarea id="servis-adi" size="sm" v-model="servis.servis_adi"></b-form-textarea>
          </b-col>
        </b-row>

        <b-row class="mb-3 row">
          <b-col sm="2">
            <label for="servis-arayuz-adi">Servis Arayüz Adı</label>
          </b-col>
          <b-col sm="10">
            <b-form-textarea id="servis-arayuz-adi" size="sm" v-model="servis.servis_arayuz_adi"></b-form-textarea>
          </b-col>
        </b-row>

        <b-row class="mb-3 row">
          <b-col sm="2" >
            <label for="sunucu-mu">Sunucu Mu</label>
          </b-col>
          <b-col sm="10">
            <b-form-select id="sunucu-mu" style="width: 100%" v-model="servis.sunucu_mu" :options="options_sunucu"></b-form-select>
          </b-col>
        </b-row>

        <b-row class="mb-3 row">
          <b-col sm="2">
            <label for="log-durumu">Log Durumu</label>
          </b-col>
          <b-col sm="10">
            <b-form-select id="log-durumu" style="width: 100%" v-model="servis.log_seviyesi" :options="options_log"></b-form-select>
          </b-col>
        </b-row>

        <div class="mb-3 row">
          <label class="col-sm-2 col-form-label"></label>
          <div class="col-sm-10 d-grid">
            <button class="btn btn-success" @click="servisKaydet">Kaydet</button>
          </div>
        </div>

      </b-modal>

      <!-- click "Güncelle" : Servis Güncelle Modal -->
      <b-modal class="modal fade" id="servis-guncelle-modal" hide-backdrop no-close-on-backdrop size="lg" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" title="Kayıt Güncelleme Ekranı" ok-only ok-title="Geri Dön">
        
        <b-row class="mb-3 row">
          <b-col sm="2">
            <label for="servis-adi">Servis Adı</label>
          </b-col>
          <b-col sm="10">
            <b-form-textarea id="servis-adi" size="sm" v-model="servis.servis_adi" :placeholder="servis.servis_adi"></b-form-textarea>
          </b-col>
        </b-row>

        <b-row class="mb-3 row">
          <b-col sm="2">
            <label for="servis-arayuz-adi">Servis Arayüz Adı</label>
          </b-col>
          <b-col sm="10">
            <b-form-textarea id="servis-arayuz-adi" size="sm" v-model="servis.servis_arayuz_adi"></b-form-textarea>
          </b-col>
        </b-row>

        <b-row class="mb-3 row">
          <b-col sm="2">
            <label for="sunucu-mu">Sunucu Mu</label>
          </b-col>
          <b-col sm="10">
            <b-form-select id="sunucu-mu" style="width: 100%" v-model="servis.sunucu_mu" :options="options_sunucu"></b-form-select>
          </b-col>
        </b-row>
        
        <b-row class="mb-3 row">
          <b-col sm="2">
            <label for="log-durumu">Log Durumu</label>
          </b-col>
          <b-col sm="10">
            <b-form-select id="log-durumu" style="width: 100%" v-model="servis.log_seviyesi" :options="options_log"></b-form-select>
          </b-col>
        </b-row>

        <b-row class="mb-3 row">
          <b-col sm="2">
            <label for="durum-id">Durum</label>
          </b-col>
          <b-col sm="10">
            <b-form-select id="durum-id" style="width: 100%" v-model="servis.durum_id" :options="options_durum"></b-form-select>
          </b-col>
        </b-row>

        <div class="mb-3 row">
          <label class="col-sm-2 col-form-label"></label>
          <div class="col-sm-10 d-grid">
            <button class="btn btn-success" @click="servisGuncelle">Güncelle</button>
          </div>
        </div>
                
      </b-modal>

    </div>     
    
  </div>
</template>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/sabitler.js"></script>

<script>
import axios from "axios";

export default {
  el: '#sorgulama-ekrani',
  data() {
    return {
      servis: {
        servis_adi: "",
        servis_arayuz_adi: "",
        sunucu_mu: "",
        log_seviyesi: "",
        durum_id: 0,
        tanitan_kullanici_id: 1
      },
      servisId: "",
      servisler: [],
      options_sunucu : [0, 1],
      options_log : [0, 1, 2, 3],
      options_durum : [0, 1, 2]
    };
  },
  methods: {
    servisKaydet() {
      var thiz = this;
      axios.post('http://localhost:9000/servis-kayit', {
        servisAdi: thiz.servis.servis_adi,
        servisArayuzAdi: thiz.servis.servis_arayuz_adi,
        logSeviyesi: thiz.servis.log_seviyesi,
        sunucuMu: thiz.servis.sunucu_mu,
        durumId: thiz.servis.durum_id,
        tanitanKullaniciId: thiz.servis.tanitan_kullanici_id
      }).then(response => {
        this.kayitlariGetir();
      })
    },
    kayitlariGetir() {
      axios.get('http://localhost:9000/kayitlar-getir')
      .then(response => {
        /*for(let element of response.data)
          this.servisler.push(element)*/
          this.servisler = response.data;
      })
    },
    guncelleServisGetir(id) {
      this.servisId = id;
      axios.get('http://localhost:9000/kayit-getir/' + id)
      .then(response => {
        this.servis = response.data;
      });
    },
    servisGuncelle() {
      var thiz = this;
      axios.put('http://localhost:9000/kayit-guncelle/' + thiz.servisId, {
        servisAdi: thiz.servis.servis_adi,
        servisArayuzAdi: thiz.servis.servis_arayuz_adi,
        logSeviyesi: thiz.servis.log_seviyesi,
        sunucuMu: thiz.servis.sunucu_mu,
        durumId: thiz.servis.durum_id,
        guncelleyenKullaniciId: thiz.servis.tanitanKullaniciId
      })
      .then(response => {
        //servisler arrayini temizle
        //sonra kayitlari getir otomatik çalışsın
        this.kayitlariGetir();
      })
    },
    gecis(id){
      this.$router.push('servisBaglantiEkrani/' + id);
    

    }
    
  },
};
</script>