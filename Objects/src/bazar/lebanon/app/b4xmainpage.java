package bazar.lebanon.app;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xmainpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "bazar.lebanon.app.b4xmainpage");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", bazar.lebanon.app.b4xmainpage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.BillingClientWrapper _billing = null;
public boolean _adsremoved = false;
public String _ads_sdk_id = "";
public String _billing_key = "";
public anywheresoftware.b4a.objects.B4XViewWrapper _btnremoveads = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _lblad = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _btnreset = null;
public bazar.lebanon.app.main _main = null;
public bazar.lebanon.app.starter _starter = null;
public bazar.lebanon.app.b4xpages _b4xpages = null;
public bazar.lebanon.app.b4xcollections _b4xcollections = null;
public String  _b4xpage_created(anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
 //BA.debugLineNum = 25;BA.debugLine="Private Sub B4XPage_Created (Root1 As B4XView)";
 //BA.debugLineNum = 26;BA.debugLine="Root = Root1";
_root = _root1;
 //BA.debugLineNum = 27;BA.debugLine="Root.LoadLayout(\"1\")";
_root.LoadLayout("1",ba);
 //BA.debugLineNum = 28;BA.debugLine="billing.Initialize(\"billing\")";
_billing.Initialize(ba,"billing");
 //BA.debugLineNum = 29;BA.debugLine="RestorePurchases";
_restorepurchases();
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return "";
}
public String  _billing_purchasesupdated(anywheresoftware.b4a.objects.BillingClientWrapper.BillingResultWrapper _result,anywheresoftware.b4a.objects.collections.List _purchases) throws Exception{
anywheresoftware.b4a.objects.BillingClientWrapper.PurchaseWrapper _p = null;
 //BA.debugLineNum = 121;BA.debugLine="Sub billing_PurchasesUpdated (Result As BillingRes";
 //BA.debugLineNum = 124;BA.debugLine="If Result.IsSuccess Then";
if (_result.getIsSuccess()) { 
 //BA.debugLineNum = 125;BA.debugLine="For Each p As Purchase In Purchases";
_p = new anywheresoftware.b4a.objects.BillingClientWrapper.PurchaseWrapper();
{
final anywheresoftware.b4a.BA.IterableList group2 = _purchases;
final int groupLen2 = group2.getSize()
;int index2 = 0;
;
for (; index2 < groupLen2;index2++){
_p = (anywheresoftware.b4a.objects.BillingClientWrapper.PurchaseWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.BillingClientWrapper.PurchaseWrapper(), (com.android.billingclient.api.Purchase)(group2.Get(index2)));
 //BA.debugLineNum = 126;BA.debugLine="If p.Sku = ADS_SDK_ID Then";
if ((_p.getSku()).equals(_ads_sdk_id)) { 
 //BA.debugLineNum = 127;BA.debugLine="HandleAdsPurchase(p)";
_handleadspurchase(_p);
 }else {
 //BA.debugLineNum = 129;BA.debugLine="Log(\"Unexpected product...\")";
__c.LogImpl("21114120","Unexpected product...",0);
 };
 }
};
 };
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return "";
}
public void  _btnremoveads_click() throws Exception{
ResumableSub_btnRemoveAds_Click rsub = new ResumableSub_btnRemoveAds_Click(this);
rsub.resume(ba, null);
}
public static class ResumableSub_btnRemoveAds_Click extends BA.ResumableSub {
public ResumableSub_btnRemoveAds_Click(bazar.lebanon.app.b4xmainpage parent) {
this.parent = parent;
}
bazar.lebanon.app.b4xmainpage parent;
anywheresoftware.b4a.objects.BillingClientWrapper.BillingResultWrapper _result = null;
Object _sf = null;
anywheresoftware.b4a.objects.collections.List _skudetails = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 97;BA.debugLine="Wait For (billing.ConnectIfNeeded) Billing_Connec";
parent.__c.WaitFor("billing_connected", ba, this, parent._billing.ConnectIfNeeded(ba));
this.state = 17;
return;
case 17:
//C
this.state = 1;
_result = (anywheresoftware.b4a.objects.BillingClientWrapper.BillingResultWrapper) result[0];
;
 //BA.debugLineNum = 98;BA.debugLine="If Result.IsSuccess Then";
if (true) break;

case 1:
//if
this.state = 16;
if (_result.getIsSuccess()) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 100;BA.debugLine="Dim sf As Object = billing.QuerySkuDetails(\"inap";
_sf = parent._billing.QuerySkuDetails(ba,"inapp",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(parent._ads_sdk_id)}));
 //BA.debugLineNum = 101;BA.debugLine="Wait For (sf) Billing_SkuQueryCompleted (Result";
parent.__c.WaitFor("billing_skuquerycompleted", ba, this, _sf);
this.state = 18;
return;
case 18:
//C
this.state = 4;
_result = (anywheresoftware.b4a.objects.BillingClientWrapper.BillingResultWrapper) result[0];
_skudetails = (anywheresoftware.b4a.objects.collections.List) result[1];
;
 //BA.debugLineNum = 102;BA.debugLine="Log (SkuDetails.Get(0))";
parent.__c.LogImpl("2983047",BA.ObjectToString(_skudetails.Get((int) (0))),0);
 //BA.debugLineNum = 103;BA.debugLine="Log(Result)";
parent.__c.LogImpl("2983048",BA.ObjectToString(_result),0);
 //BA.debugLineNum = 104;BA.debugLine="If Result.IsSuccess And SkuDetails.Size = 1 Then";
if (true) break;

case 4:
//if
this.state = 15;
if (_result.getIsSuccess() && _skudetails.getSize()==1) { 
this.state = 6;
}else {
this.state = 14;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 106;BA.debugLine="Result = billing.LaunchBillingFlow(SkuDetails.G";
_result = parent._billing.LaunchBillingFlow(ba,(anywheresoftware.b4a.objects.BillingClientWrapper.SkuDetailsWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.BillingClientWrapper.SkuDetailsWrapper(), (com.android.billingclient.api.ProductDetails)(_skudetails.Get((int) (0)))));
 //BA.debugLineNum = 107;BA.debugLine="If Result.IsSuccess Then Return";
if (true) break;

case 7:
//if
this.state = 12;
if (_result.getIsSuccess()) { 
this.state = 9;
;}if (true) break;

case 9:
//C
this.state = 12;
if (true) return ;
if (true) break;

case 12:
//C
this.state = 15;
;
 if (true) break;

case 14:
//C
this.state = 15;
 //BA.debugLineNum = 109;BA.debugLine="Log(Result.DebugMessage)";
parent.__c.LogImpl("2983054",_result.getDebugMessage(),0);
 if (true) break;

case 15:
//C
this.state = 16;
;
 if (true) break;

case 16:
//C
this.state = -1;
;
 //BA.debugLineNum = 112;BA.debugLine="ToastMessageShow(\"Error starting billing process\"";
parent.__c.ToastMessageShow(BA.ObjectToCharSequence("Error starting billing process"),parent.__c.True);
 //BA.debugLineNum = 113;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _billing_connected(anywheresoftware.b4a.objects.BillingClientWrapper.BillingResultWrapper _result) throws Exception{
}
public void  _billing_skuquerycompleted(anywheresoftware.b4a.objects.BillingClientWrapper.BillingResultWrapper _result,anywheresoftware.b4a.objects.collections.List _skudetails) throws Exception{
}
public String  _btnreset_click() throws Exception{
 //BA.debugLineNum = 115;BA.debugLine="Sub btnReset_Click";
 //BA.debugLineNum = 116;BA.debugLine="ResetAds";
_resetads();
 //BA.debugLineNum = 117;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 8;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private Root As B4XView";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 11;BA.debugLine="Public billing As BillingClient";
_billing = new anywheresoftware.b4a.objects.BillingClientWrapper();
 //BA.debugLineNum = 12;BA.debugLine="Public AdsRemoved As Boolean";
_adsremoved = false;
 //BA.debugLineNum = 13;BA.debugLine="Public const ADS_SDK_ID As String = \"abc1.abc1\"";
_ads_sdk_id = "abc1.abc1";
 //BA.debugLineNum = 14;BA.debugLine="Public const BILLING_KEY As String = \"MIIBIjANBgk";
_billing_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAluDOUv++zEHK1pN4DTfVfiBv8BVQgf/sIVErRDd12QiwMLptpmeDziMjBrO6uZRuiLxG3Rhz34QzFOpztQXg5ri77tRW+nb01s8HgVCkR74Hq1JL3J7AFC2yRX7DmyLS0iO167lLNKcGgsh6UBo0zqCIOC6BcGpF57JIGnK5NPZZmsK/WgwrftDpyDdv4/M6kJjpMQ81Byd9ba37ytTeaFOE1bAJMo3vuZjUjoPd9dNZCFL9O8SszB8uVF/UAAovM8FkB8FfIC4Hx/dq1CtGp8pr5mmKm3T2XxuOrxAzk6jSb+RmJ249E8kOcsRN5HXHUpVRvSJrPcWXm/UNQYTflQIDAQAB";
 //BA.debugLineNum = 15;BA.debugLine="Private btnRemoveAds As B4XView";
_btnremoveads = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private lblAd As B4XView";
_lblad = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private btnReset As B4XView";
_btnreset = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return "";
}
public void  _consumeadsproduct(anywheresoftware.b4a.objects.collections.List _purchases) throws Exception{
ResumableSub_ConsumeAdsProduct rsub = new ResumableSub_ConsumeAdsProduct(this,_purchases);
rsub.resume(ba, null);
}
public static class ResumableSub_ConsumeAdsProduct extends BA.ResumableSub {
public ResumableSub_ConsumeAdsProduct(bazar.lebanon.app.b4xmainpage parent,anywheresoftware.b4a.objects.collections.List _purchases) {
this.parent = parent;
this._purchases = _purchases;
}
bazar.lebanon.app.b4xmainpage parent;
anywheresoftware.b4a.objects.collections.List _purchases;
anywheresoftware.b4a.objects.BillingClientWrapper.PurchaseWrapper _p = null;
anywheresoftware.b4a.objects.BillingClientWrapper.BillingResultWrapper _result = null;
anywheresoftware.b4a.BA.IterableList group1;
int index1;
int groupLen1;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 165;BA.debugLine="For Each p As Purchase In Purchases";
if (true) break;

case 1:
//for
this.state = 12;
_p = new anywheresoftware.b4a.objects.BillingClientWrapper.PurchaseWrapper();
group1 = _purchases;
index1 = 0;
groupLen1 = group1.getSize();
this.state = 13;
if (true) break;

case 13:
//C
this.state = 12;
if (index1 < groupLen1) {
this.state = 3;
_p = (anywheresoftware.b4a.objects.BillingClientWrapper.PurchaseWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.BillingClientWrapper.PurchaseWrapper(), (com.android.billingclient.api.Purchase)(group1.Get(index1)));}
if (true) break;

case 14:
//C
this.state = 13;
index1++;
if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 166;BA.debugLine="If p.Sku = ADS_SDK_ID Then";
if (true) break;

case 4:
//if
this.state = 11;
if ((_p.getSku()).equals(parent._ads_sdk_id)) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 167;BA.debugLine="Wait For (billing.Consume(p.PurchaseToken, \"\"))";
parent.__c.WaitFor("billing_consumecompleted", ba, this, parent._billing.Consume(ba,_p.getPurchaseToken(),""));
this.state = 15;
return;
case 15:
//C
this.state = 7;
_result = (anywheresoftware.b4a.objects.BillingClientWrapper.BillingResultWrapper) result[0];
;
 //BA.debugLineNum = 168;BA.debugLine="If Result.IsSuccess Then";
if (true) break;

case 7:
//if
this.state = 10;
if (_result.getIsSuccess()) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 169;BA.debugLine="Log(\"consumed\")";
parent.__c.LogImpl("21310725","consumed",0);
 //BA.debugLineNum = 170;BA.debugLine="AdsRemoved = False";
parent._adsremoved = parent.__c.False;
 //BA.debugLineNum = 171;BA.debugLine="UpdateAdsState";
parent._updateadsstate();
 if (true) break;

case 10:
//C
this.state = 11;
;
 if (true) break;

case 11:
//C
this.state = 14;
;
 if (true) break;
if (true) break;

case 12:
//C
this.state = -1;
;
 //BA.debugLineNum = 175;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _billing_consumecompleted(anywheresoftware.b4a.objects.BillingClientWrapper.BillingResultWrapper _result) throws Exception{
}
public void  _handleadspurchase(anywheresoftware.b4a.objects.BillingClientWrapper.PurchaseWrapper _p) throws Exception{
ResumableSub_HandleAdsPurchase rsub = new ResumableSub_HandleAdsPurchase(this,_p);
rsub.resume(ba, null);
}
public static class ResumableSub_HandleAdsPurchase extends BA.ResumableSub {
public ResumableSub_HandleAdsPurchase(bazar.lebanon.app.b4xmainpage parent,anywheresoftware.b4a.objects.BillingClientWrapper.PurchaseWrapper _p) {
this.parent = parent;
this._p = _p;
}
bazar.lebanon.app.b4xmainpage parent;
anywheresoftware.b4a.objects.BillingClientWrapper.PurchaseWrapper _p;
anywheresoftware.b4a.objects.BillingClientWrapper.BillingResultWrapper _result = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 136;BA.debugLine="If p.PurchaseState <> p.STATE_PURCHASED Then Retu";
if (true) break;

case 1:
//if
this.state = 6;
if (_p.getPurchaseState()!=_p.STATE_PURCHASED) { 
this.state = 3;
;}if (true) break;

case 3:
//C
this.state = 6;
if (true) return ;
if (true) break;

case 6:
//C
this.state = 7;
;
 //BA.debugLineNum = 139;BA.debugLine="If p.Sku.StartsWith(\"abc1\") = False And billing.V";
if (true) break;

case 7:
//if
this.state = 10;
if (_p.getSku().startsWith("abc1")==parent.__c.False && parent._billing.VerifyPurchase(_p,parent._billing_key)==parent.__c.False) { 
this.state = 9;
}if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 140;BA.debugLine="Log(\"Invalid purchase\")";
parent.__c.LogImpl("21179653","Invalid purchase",0);
 //BA.debugLineNum = 141;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
 //BA.debugLineNum = 143;BA.debugLine="If p.IsAcknowledged = False Then";

case 10:
//if
this.state = 13;
if (_p.getIsAcknowledged()==parent.__c.False) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
 //BA.debugLineNum = 145;BA.debugLine="Wait For (billing.AcknowledgePurchase(p.Purchase";
parent.__c.WaitFor("billing_acknowledgecompleted", ba, this, parent._billing.AcknowledgePurchase(ba,_p.getPurchaseToken(),""));
this.state = 14;
return;
case 14:
//C
this.state = 13;
_result = (anywheresoftware.b4a.objects.BillingClientWrapper.BillingResultWrapper) result[0];
;
 //BA.debugLineNum = 146;BA.debugLine="Log(\"Acknowledged: \" & Result.IsSuccess)";
parent.__c.LogImpl("21179659","Acknowledged: "+BA.ObjectToString(_result.getIsSuccess()),0);
 if (true) break;

case 13:
//C
this.state = -1;
;
 //BA.debugLineNum = 148;BA.debugLine="AdsRemoved = True";
parent._adsremoved = parent.__c.True;
 //BA.debugLineNum = 149;BA.debugLine="Log(\"AdsRemoved\")";
parent.__c.LogImpl("21179662","AdsRemoved",0);
 //BA.debugLineNum = 150;BA.debugLine="UpdateAdsState";
parent._updateadsstate();
 //BA.debugLineNum = 151;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _billing_acknowledgecompleted(anywheresoftware.b4a.objects.BillingClientWrapper.BillingResultWrapper _result) throws Exception{
}
public String  _initialize(anywheresoftware.b4a.BA _ba) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 20;BA.debugLine="Public Sub Initialize";
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.BillingClientWrapper.BillingResultWrapper  _launchbillingflow1(anywheresoftware.b4a.objects.BillingClientWrapper _client,anywheresoftware.b4a.objects.BillingClientWrapper.SkuDetailsWrapper _sku,String _offertoken) throws Exception{
anywheresoftware.b4j.object.JavaObject _ctxt = null;
anywheresoftware.b4j.object.JavaObject _productdetailsparamsbuilder = null;
anywheresoftware.b4a.objects.collections.List _productdetails = null;
anywheresoftware.b4j.object.JavaObject _billingflowparamsbuilder = null;
 //BA.debugLineNum = 43;BA.debugLine="Private Sub LaunchBillingFlow1 (Client As BillingC";
 //BA.debugLineNum = 45;BA.debugLine="Dim ctxt As JavaObject";
_ctxt = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 46;BA.debugLine="ctxt.InitializeContext";
_ctxt.InitializeContext(ba);
 //BA.debugLineNum = 47;BA.debugLine="Dim ProductDetailsParamsBuilder As JavaObject";
_productdetailsparamsbuilder = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 48;BA.debugLine="ProductDetailsParamsBuilder = ProductDetailsParam";
_productdetailsparamsbuilder = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_productdetailsparamsbuilder.InitializeStatic("com.android.billingclient.api.BillingFlowParams.ProductDetailsParams").RunMethod("newBuilder",(Object[])(__c.Null))));
 //BA.debugLineNum = 49;BA.debugLine="ProductDetailsParamsBuilder.RunMethod(\"setProduct";
_productdetailsparamsbuilder.RunMethod("setProductDetails",new Object[]{(Object)(_sku.getObject())});
 //BA.debugLineNum = 50;BA.debugLine="ProductDetailsParamsBuilder.RunMethod(\"setOfferTo";
_productdetailsparamsbuilder.RunMethod("setOfferToken",new Object[]{(Object)(_offertoken)});
 //BA.debugLineNum = 51;BA.debugLine="Dim ProductDetails As List = Array(ProductDetails";
_productdetails = new anywheresoftware.b4a.objects.collections.List();
_productdetails = anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{_productdetailsparamsbuilder.RunMethod("build",(Object[])(__c.Null))});
 //BA.debugLineNum = 53;BA.debugLine="Dim BillingFlowParamsBuilder As JavaObject";
_billingflowparamsbuilder = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 54;BA.debugLine="BillingFlowParamsBuilder = BillingFlowParamsBuild";
_billingflowparamsbuilder = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_billingflowparamsbuilder.InitializeStatic("com.android.billingclient.api.BillingFlowParams").RunMethod("newBuilder",(Object[])(__c.Null))));
 //BA.debugLineNum = 55;BA.debugLine="BillingFlowParamsBuilder.RunMethod(\"setProductDet";
_billingflowparamsbuilder.RunMethod("setProductDetailsParamsList",new Object[]{(Object)(_productdetails.getObject())});
 //BA.debugLineNum = 57;BA.debugLine="Return Client.As(JavaObject).GetFieldJO(\"client\")";
if (true) return (anywheresoftware.b4a.objects.BillingClientWrapper.BillingResultWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.BillingClientWrapper.BillingResultWrapper(), (com.android.billingclient.api.BillingResult)(((anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_client))).GetFieldJO("client").RunMethod("launchBillingFlow",new Object[]{(Object)(_ctxt.getObject()),_billingflowparamsbuilder.RunMethod("build",(Object[])(__c.Null))})));
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return null;
}
public void  _resetads() throws Exception{
ResumableSub_ResetAds rsub = new ResumableSub_ResetAds(this);
rsub.resume(ba, null);
}
public static class ResumableSub_ResetAds extends BA.ResumableSub {
public ResumableSub_ResetAds(bazar.lebanon.app.b4xmainpage parent) {
this.parent = parent;
}
bazar.lebanon.app.b4xmainpage parent;
anywheresoftware.b4a.objects.BillingClientWrapper.BillingResultWrapper _result = null;
anywheresoftware.b4a.objects.collections.List _purchases = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 155;BA.debugLine="Wait For (billing.ConnectIfNeeded) Billing_Connec";
parent.__c.WaitFor("billing_connected", ba, this, parent._billing.ConnectIfNeeded(ba));
this.state = 9;
return;
case 9:
//C
this.state = 1;
_result = (anywheresoftware.b4a.objects.BillingClientWrapper.BillingResultWrapper) result[0];
;
 //BA.debugLineNum = 156;BA.debugLine="If Result.IsSuccess Then";
if (true) break;

case 1:
//if
this.state = 8;
if (_result.getIsSuccess()) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 157;BA.debugLine="Wait For (billing.QueryPurchases(\"inapp\")) Billi";
parent.__c.WaitFor("billing_purchasesquerycompleted", ba, this, parent._billing.QueryPurchases(ba,"inapp"));
this.state = 10;
return;
case 10:
//C
this.state = 4;
_result = (anywheresoftware.b4a.objects.BillingClientWrapper.BillingResultWrapper) result[0];
_purchases = (anywheresoftware.b4a.objects.collections.List) result[1];
;
 //BA.debugLineNum = 158;BA.debugLine="If Result.IsSuccess Then";
if (true) break;

case 4:
//if
this.state = 7;
if (_result.getIsSuccess()) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 159;BA.debugLine="ConsumeAdsProduct(Purchases)";
parent._consumeadsproduct(_purchases);
 if (true) break;

case 7:
//C
this.state = 8;
;
 if (true) break;

case 8:
//C
this.state = -1;
;
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _billing_purchasesquerycompleted(anywheresoftware.b4a.objects.BillingClientWrapper.BillingResultWrapper _result,anywheresoftware.b4a.objects.collections.List _purchases) throws Exception{
}
public void  _restorepurchases() throws Exception{
ResumableSub_RestorePurchases rsub = new ResumableSub_RestorePurchases(this);
rsub.resume(ba, null);
}
public static class ResumableSub_RestorePurchases extends BA.ResumableSub {
public ResumableSub_RestorePurchases(bazar.lebanon.app.b4xmainpage parent) {
this.parent = parent;
}
bazar.lebanon.app.b4xmainpage parent;
anywheresoftware.b4a.objects.BillingClientWrapper.BillingResultWrapper _result = null;
anywheresoftware.b4a.objects.collections.List _purchases = null;
anywheresoftware.b4a.objects.BillingClientWrapper.PurchaseWrapper _p = null;
anywheresoftware.b4a.BA.IterableList group6;
int index6;
int groupLen6;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 83;BA.debugLine="Wait For (billing.ConnectIfNeeded) Billing_Connec";
parent.__c.WaitFor("billing_connected", ba, this, parent._billing.ConnectIfNeeded(ba));
this.state = 19;
return;
case 19:
//C
this.state = 1;
_result = (anywheresoftware.b4a.objects.BillingClientWrapper.BillingResultWrapper) result[0];
;
 //BA.debugLineNum = 84;BA.debugLine="If Result.IsSuccess Then";
if (true) break;

case 1:
//if
this.state = 18;
if (_result.getIsSuccess()) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 85;BA.debugLine="Wait For (billing.QueryPurchases(\"inapp\")) Billi";
parent.__c.WaitFor("billing_purchasesquerycompleted", ba, this, parent._billing.QueryPurchases(ba,"inapp"));
this.state = 20;
return;
case 20:
//C
this.state = 4;
_result = (anywheresoftware.b4a.objects.BillingClientWrapper.BillingResultWrapper) result[0];
_purchases = (anywheresoftware.b4a.objects.collections.List) result[1];
;
 //BA.debugLineNum = 86;BA.debugLine="Log(\"Query completed: \" & Result.IsSuccess)";
parent.__c.LogImpl("2917508","Query completed: "+BA.ObjectToString(_result.getIsSuccess()),0);
 //BA.debugLineNum = 87;BA.debugLine="If Result.IsSuccess Then";
if (true) break;

case 4:
//if
this.state = 17;
if (_result.getIsSuccess()) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 88;BA.debugLine="For Each p As Purchase In Purchases";
if (true) break;

case 7:
//for
this.state = 16;
_p = new anywheresoftware.b4a.objects.BillingClientWrapper.PurchaseWrapper();
group6 = _purchases;
index6 = 0;
groupLen6 = group6.getSize();
this.state = 21;
if (true) break;

case 21:
//C
this.state = 16;
if (index6 < groupLen6) {
this.state = 9;
_p = (anywheresoftware.b4a.objects.BillingClientWrapper.PurchaseWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.BillingClientWrapper.PurchaseWrapper(), (com.android.billingclient.api.Purchase)(group6.Get(index6)));}
if (true) break;

case 22:
//C
this.state = 21;
index6++;
if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 89;BA.debugLine="If p.Sku = ADS_SDK_ID Then HandleAdsPurchase(p";
if (true) break;

case 10:
//if
this.state = 15;
if ((_p.getSku()).equals(parent._ads_sdk_id)) { 
this.state = 12;
;}if (true) break;

case 12:
//C
this.state = 15;
parent._handleadspurchase(_p);
if (true) break;

case 15:
//C
this.state = 22;
;
 if (true) break;
if (true) break;

case 16:
//C
this.state = 17;
;
 if (true) break;

case 17:
//C
this.state = 18;
;
 if (true) break;

case 18:
//C
this.state = -1;
;
 //BA.debugLineNum = 93;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _updateadsstate() throws Exception{
 //BA.debugLineNum = 76;BA.debugLine="Private Sub UpdateAdsState";
 //BA.debugLineNum = 77;BA.debugLine="lblAd.Visible = Not(AdsRemoved)";
_lblad.setVisible(__c.Not(_adsremoved));
 //BA.debugLineNum = 78;BA.debugLine="btnRemoveAds.Enabled = Not(AdsRemoved)";
_btnremoveads.setEnabled(__c.Not(_adsremoved));
 //BA.debugLineNum = 79;BA.debugLine="btnReset.Enabled = AdsRemoved";
_btnreset.setEnabled(_adsremoved);
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
if (BA.fastSubCompare(sub, "B4XPAGE_CREATED"))
	return _b4xpage_created((anywheresoftware.b4a.objects.B4XViewWrapper) args[0]);
return BA.SubDelegator.SubNotFound;
}
}
