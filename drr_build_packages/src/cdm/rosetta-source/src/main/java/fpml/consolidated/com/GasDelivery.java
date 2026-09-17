package fpml.consolidated.com;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.com.meta.GasDeliveryMeta;
import fpml.consolidated.fpmlenum.DeliveryTypeEnum;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The specification of the gas to be delivered.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The specification of the gas to be delivered.
 *
 */
@RosettaDataType(value="GasDelivery", builder=GasDelivery.GasDeliveryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="GasDelivery", model="fpml", builder=GasDelivery.GasDeliveryBuilderImpl.class, version="2.1.1")
public interface GasDelivery extends RosettaModelObject {

	GasDeliveryMeta metaData = new GasDeliveryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The physical or virtual point at which the commodity will be delivered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The physical or virtual point at which the commodity will be delivered.
	 *
	 */
	GasDeliveryPoint getDeliveryPoint();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The physical or virtual point at which the commodity enters a transportation system.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The physical or virtual point at which the commodity enters a transportation system.
	 *
	 */
	CommodityDeliveryPoint getEntryPoint();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The physical or virtual point at which the commodity is withdrawn from a transportation system.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The physical or virtual point at which the commodity is withdrawn from a transportation system.
	 *
	 */
	CommodityDeliveryPoint getWithdrawalPoint();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates whether the buyer and seller are contractually obliged to consume and supply the specified quantities of the commodity.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates whether the buyer and seller are contractually obliged to consume and supply the specified quantities of the commodity.
	 *
	 */
	DeliveryTypeEnum getDeliveryType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identification of the border(s) or border point(s) of a transportation contract.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identification of the border(s) or border point(s) of a transportation contract.
	 *
	 */
	InterconnectionPoint getInterconnectionPoint();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The hub code of the gas buyer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The hub code of the gas buyer.
	 *
	 */
	CommodityHub getBuyerHub();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The hub code of the has seller.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The hub code of the has seller.
	 *
	 */
	CommodityHub getSellerHub();

	/*********************** Build Methods  ***********************/
	GasDelivery build();
	
	GasDelivery.GasDeliveryBuilder toBuilder();
	
	static GasDelivery.GasDeliveryBuilder builder() {
		return new GasDelivery.GasDeliveryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GasDelivery> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GasDelivery> getType() {
		return GasDelivery.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("deliveryPoint"), processor, GasDeliveryPoint.class, getDeliveryPoint());
		processRosetta(path.newSubPath("entryPoint"), processor, CommodityDeliveryPoint.class, getEntryPoint());
		processRosetta(path.newSubPath("withdrawalPoint"), processor, CommodityDeliveryPoint.class, getWithdrawalPoint());
		processor.processBasic(path.newSubPath("deliveryType"), DeliveryTypeEnum.class, getDeliveryType(), this);
		processRosetta(path.newSubPath("interconnectionPoint"), processor, InterconnectionPoint.class, getInterconnectionPoint());
		processRosetta(path.newSubPath("buyerHub"), processor, CommodityHub.class, getBuyerHub());
		processRosetta(path.newSubPath("sellerHub"), processor, CommodityHub.class, getSellerHub());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GasDeliveryBuilder extends GasDelivery, RosettaModelObjectBuilder {
		GasDeliveryPoint.GasDeliveryPointBuilder getOrCreateDeliveryPoint();
		@Override
		GasDeliveryPoint.GasDeliveryPointBuilder getDeliveryPoint();
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateEntryPoint();
		@Override
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getEntryPoint();
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateWithdrawalPoint();
		@Override
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getWithdrawalPoint();
		InterconnectionPoint.InterconnectionPointBuilder getOrCreateInterconnectionPoint();
		@Override
		InterconnectionPoint.InterconnectionPointBuilder getInterconnectionPoint();
		CommodityHub.CommodityHubBuilder getOrCreateBuyerHub();
		@Override
		CommodityHub.CommodityHubBuilder getBuyerHub();
		CommodityHub.CommodityHubBuilder getOrCreateSellerHub();
		@Override
		CommodityHub.CommodityHubBuilder getSellerHub();
		GasDelivery.GasDeliveryBuilder setDeliveryPoint(GasDeliveryPoint deliveryPoint);
		GasDelivery.GasDeliveryBuilder setEntryPoint(CommodityDeliveryPoint entryPoint);
		GasDelivery.GasDeliveryBuilder setWithdrawalPoint(CommodityDeliveryPoint withdrawalPoint);
		GasDelivery.GasDeliveryBuilder setDeliveryType(DeliveryTypeEnum deliveryType);
		GasDelivery.GasDeliveryBuilder setInterconnectionPoint(InterconnectionPoint interconnectionPoint);
		GasDelivery.GasDeliveryBuilder setBuyerHub(CommodityHub buyerHub);
		GasDelivery.GasDeliveryBuilder setSellerHub(CommodityHub sellerHub);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("deliveryPoint"), processor, GasDeliveryPoint.GasDeliveryPointBuilder.class, getDeliveryPoint());
			processRosetta(path.newSubPath("entryPoint"), processor, CommodityDeliveryPoint.CommodityDeliveryPointBuilder.class, getEntryPoint());
			processRosetta(path.newSubPath("withdrawalPoint"), processor, CommodityDeliveryPoint.CommodityDeliveryPointBuilder.class, getWithdrawalPoint());
			processor.processBasic(path.newSubPath("deliveryType"), DeliveryTypeEnum.class, getDeliveryType(), this);
			processRosetta(path.newSubPath("interconnectionPoint"), processor, InterconnectionPoint.InterconnectionPointBuilder.class, getInterconnectionPoint());
			processRosetta(path.newSubPath("buyerHub"), processor, CommodityHub.CommodityHubBuilder.class, getBuyerHub());
			processRosetta(path.newSubPath("sellerHub"), processor, CommodityHub.CommodityHubBuilder.class, getSellerHub());
		}
		

		GasDelivery.GasDeliveryBuilder prune();
	}

	/*********************** Immutable Implementation of GasDelivery  ***********************/
	class GasDeliveryImpl implements GasDelivery {
		private final GasDeliveryPoint deliveryPoint;
		private final CommodityDeliveryPoint entryPoint;
		private final CommodityDeliveryPoint withdrawalPoint;
		private final DeliveryTypeEnum deliveryType;
		private final InterconnectionPoint interconnectionPoint;
		private final CommodityHub buyerHub;
		private final CommodityHub sellerHub;
		
		protected GasDeliveryImpl(GasDelivery.GasDeliveryBuilder builder) {
			this.deliveryPoint = ofNullable(builder.getDeliveryPoint()).map(f->f.build()).orElse(null);
			this.entryPoint = ofNullable(builder.getEntryPoint()).map(f->f.build()).orElse(null);
			this.withdrawalPoint = ofNullable(builder.getWithdrawalPoint()).map(f->f.build()).orElse(null);
			this.deliveryType = builder.getDeliveryType();
			this.interconnectionPoint = ofNullable(builder.getInterconnectionPoint()).map(f->f.build()).orElse(null);
			this.buyerHub = ofNullable(builder.getBuyerHub()).map(f->f.build()).orElse(null);
			this.sellerHub = ofNullable(builder.getSellerHub()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("deliveryPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryPoint")
		public GasDeliveryPoint getDeliveryPoint() {
			return deliveryPoint;
		}
		
		@Override
		@RosettaAttribute("entryPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entryPoint")
		public CommodityDeliveryPoint getEntryPoint() {
			return entryPoint;
		}
		
		@Override
		@RosettaAttribute("withdrawalPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("withdrawalPoint")
		public CommodityDeliveryPoint getWithdrawalPoint() {
			return withdrawalPoint;
		}
		
		@Override
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryType")
		public DeliveryTypeEnum getDeliveryType() {
			return deliveryType;
		}
		
		@Override
		@RosettaAttribute("interconnectionPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interconnectionPoint")
		public InterconnectionPoint getInterconnectionPoint() {
			return interconnectionPoint;
		}
		
		@Override
		@RosettaAttribute("buyerHub")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerHub")
		public CommodityHub getBuyerHub() {
			return buyerHub;
		}
		
		@Override
		@RosettaAttribute("sellerHub")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerHub")
		public CommodityHub getSellerHub() {
			return sellerHub;
		}
		
		@Override
		public GasDelivery build() {
			return this;
		}
		
		@Override
		public GasDelivery.GasDeliveryBuilder toBuilder() {
			GasDelivery.GasDeliveryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GasDelivery.GasDeliveryBuilder builder) {
			ofNullable(getDeliveryPoint()).ifPresent(builder::setDeliveryPoint);
			ofNullable(getEntryPoint()).ifPresent(builder::setEntryPoint);
			ofNullable(getWithdrawalPoint()).ifPresent(builder::setWithdrawalPoint);
			ofNullable(getDeliveryType()).ifPresent(builder::setDeliveryType);
			ofNullable(getInterconnectionPoint()).ifPresent(builder::setInterconnectionPoint);
			ofNullable(getBuyerHub()).ifPresent(builder::setBuyerHub);
			ofNullable(getSellerHub()).ifPresent(builder::setSellerHub);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GasDelivery _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPoint, _that.getDeliveryPoint())) return false;
			if (!Objects.equals(entryPoint, _that.getEntryPoint())) return false;
			if (!Objects.equals(withdrawalPoint, _that.getWithdrawalPoint())) return false;
			if (!Objects.equals(deliveryType, _that.getDeliveryType())) return false;
			if (!Objects.equals(interconnectionPoint, _that.getInterconnectionPoint())) return false;
			if (!Objects.equals(buyerHub, _that.getBuyerHub())) return false;
			if (!Objects.equals(sellerHub, _that.getSellerHub())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryPoint != null ? deliveryPoint.hashCode() : 0);
			_result = 31 * _result + (entryPoint != null ? entryPoint.hashCode() : 0);
			_result = 31 * _result + (withdrawalPoint != null ? withdrawalPoint.hashCode() : 0);
			_result = 31 * _result + (deliveryType != null ? deliveryType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (interconnectionPoint != null ? interconnectionPoint.hashCode() : 0);
			_result = 31 * _result + (buyerHub != null ? buyerHub.hashCode() : 0);
			_result = 31 * _result + (sellerHub != null ? sellerHub.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasDelivery {" +
				"deliveryPoint=" + this.deliveryPoint + ", " +
				"entryPoint=" + this.entryPoint + ", " +
				"withdrawalPoint=" + this.withdrawalPoint + ", " +
				"deliveryType=" + this.deliveryType + ", " +
				"interconnectionPoint=" + this.interconnectionPoint + ", " +
				"buyerHub=" + this.buyerHub + ", " +
				"sellerHub=" + this.sellerHub +
			'}';
		}
	}

	/*********************** Builder Implementation of GasDelivery  ***********************/
	class GasDeliveryBuilderImpl implements GasDelivery.GasDeliveryBuilder {
	
		protected GasDeliveryPoint.GasDeliveryPointBuilder deliveryPoint;
		protected CommodityDeliveryPoint.CommodityDeliveryPointBuilder entryPoint;
		protected CommodityDeliveryPoint.CommodityDeliveryPointBuilder withdrawalPoint;
		protected DeliveryTypeEnum deliveryType;
		protected InterconnectionPoint.InterconnectionPointBuilder interconnectionPoint;
		protected CommodityHub.CommodityHubBuilder buyerHub;
		protected CommodityHub.CommodityHubBuilder sellerHub;
		
		@Override
		@RosettaAttribute("deliveryPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryPoint")
		public GasDeliveryPoint.GasDeliveryPointBuilder getDeliveryPoint() {
			return deliveryPoint;
		}
		
		@Override
		public GasDeliveryPoint.GasDeliveryPointBuilder getOrCreateDeliveryPoint() {
			GasDeliveryPoint.GasDeliveryPointBuilder result;
			if (deliveryPoint!=null) {
				result = deliveryPoint;
			}
			else {
				result = deliveryPoint = GasDeliveryPoint.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("entryPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("entryPoint")
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getEntryPoint() {
			return entryPoint;
		}
		
		@Override
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateEntryPoint() {
			CommodityDeliveryPoint.CommodityDeliveryPointBuilder result;
			if (entryPoint!=null) {
				result = entryPoint;
			}
			else {
				result = entryPoint = CommodityDeliveryPoint.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("withdrawalPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("withdrawalPoint")
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getWithdrawalPoint() {
			return withdrawalPoint;
		}
		
		@Override
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateWithdrawalPoint() {
			CommodityDeliveryPoint.CommodityDeliveryPointBuilder result;
			if (withdrawalPoint!=null) {
				result = withdrawalPoint;
			}
			else {
				result = withdrawalPoint = CommodityDeliveryPoint.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryType")
		public DeliveryTypeEnum getDeliveryType() {
			return deliveryType;
		}
		
		@Override
		@RosettaAttribute("interconnectionPoint")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("interconnectionPoint")
		public InterconnectionPoint.InterconnectionPointBuilder getInterconnectionPoint() {
			return interconnectionPoint;
		}
		
		@Override
		public InterconnectionPoint.InterconnectionPointBuilder getOrCreateInterconnectionPoint() {
			InterconnectionPoint.InterconnectionPointBuilder result;
			if (interconnectionPoint!=null) {
				result = interconnectionPoint;
			}
			else {
				result = interconnectionPoint = InterconnectionPoint.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("buyerHub")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerHub")
		public CommodityHub.CommodityHubBuilder getBuyerHub() {
			return buyerHub;
		}
		
		@Override
		public CommodityHub.CommodityHubBuilder getOrCreateBuyerHub() {
			CommodityHub.CommodityHubBuilder result;
			if (buyerHub!=null) {
				result = buyerHub;
			}
			else {
				result = buyerHub = CommodityHub.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellerHub")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerHub")
		public CommodityHub.CommodityHubBuilder getSellerHub() {
			return sellerHub;
		}
		
		@Override
		public CommodityHub.CommodityHubBuilder getOrCreateSellerHub() {
			CommodityHub.CommodityHubBuilder result;
			if (sellerHub!=null) {
				result = sellerHub;
			}
			else {
				result = sellerHub = CommodityHub.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("deliveryPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryPoint")
		@Override
		public GasDelivery.GasDeliveryBuilder setDeliveryPoint(GasDeliveryPoint _deliveryPoint) {
			this.deliveryPoint = _deliveryPoint == null ? null : _deliveryPoint.toBuilder();
			return this;
		}
		
		@RosettaAttribute("entryPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("entryPoint")
		@Override
		public GasDelivery.GasDeliveryBuilder setEntryPoint(CommodityDeliveryPoint _entryPoint) {
			this.entryPoint = _entryPoint == null ? null : _entryPoint.toBuilder();
			return this;
		}
		
		@RosettaAttribute("withdrawalPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("withdrawalPoint")
		@Override
		public GasDelivery.GasDeliveryBuilder setWithdrawalPoint(CommodityDeliveryPoint _withdrawalPoint) {
			this.withdrawalPoint = _withdrawalPoint == null ? null : _withdrawalPoint.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryType")
		@Override
		public GasDelivery.GasDeliveryBuilder setDeliveryType(DeliveryTypeEnum _deliveryType) {
			this.deliveryType = _deliveryType == null ? null : _deliveryType;
			return this;
		}
		
		@RosettaAttribute("interconnectionPoint")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("interconnectionPoint")
		@Override
		public GasDelivery.GasDeliveryBuilder setInterconnectionPoint(InterconnectionPoint _interconnectionPoint) {
			this.interconnectionPoint = _interconnectionPoint == null ? null : _interconnectionPoint.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerHub")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerHub")
		@Override
		public GasDelivery.GasDeliveryBuilder setBuyerHub(CommodityHub _buyerHub) {
			this.buyerHub = _buyerHub == null ? null : _buyerHub.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerHub")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerHub")
		@Override
		public GasDelivery.GasDeliveryBuilder setSellerHub(CommodityHub _sellerHub) {
			this.sellerHub = _sellerHub == null ? null : _sellerHub.toBuilder();
			return this;
		}
		
		@Override
		public GasDelivery build() {
			return new GasDelivery.GasDeliveryImpl(this);
		}
		
		@Override
		public GasDelivery.GasDeliveryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasDelivery.GasDeliveryBuilder prune() {
			if (deliveryPoint!=null && !deliveryPoint.prune().hasData()) deliveryPoint = null;
			if (entryPoint!=null && !entryPoint.prune().hasData()) entryPoint = null;
			if (withdrawalPoint!=null && !withdrawalPoint.prune().hasData()) withdrawalPoint = null;
			if (interconnectionPoint!=null && !interconnectionPoint.prune().hasData()) interconnectionPoint = null;
			if (buyerHub!=null && !buyerHub.prune().hasData()) buyerHub = null;
			if (sellerHub!=null && !sellerHub.prune().hasData()) sellerHub = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeliveryPoint()!=null && getDeliveryPoint().hasData()) return true;
			if (getEntryPoint()!=null && getEntryPoint().hasData()) return true;
			if (getWithdrawalPoint()!=null && getWithdrawalPoint().hasData()) return true;
			if (getDeliveryType()!=null) return true;
			if (getInterconnectionPoint()!=null && getInterconnectionPoint().hasData()) return true;
			if (getBuyerHub()!=null && getBuyerHub().hasData()) return true;
			if (getSellerHub()!=null && getSellerHub().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasDelivery.GasDeliveryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GasDelivery.GasDeliveryBuilder o = (GasDelivery.GasDeliveryBuilder) other;
			
			merger.mergeRosetta(getDeliveryPoint(), o.getDeliveryPoint(), this::setDeliveryPoint);
			merger.mergeRosetta(getEntryPoint(), o.getEntryPoint(), this::setEntryPoint);
			merger.mergeRosetta(getWithdrawalPoint(), o.getWithdrawalPoint(), this::setWithdrawalPoint);
			merger.mergeRosetta(getInterconnectionPoint(), o.getInterconnectionPoint(), this::setInterconnectionPoint);
			merger.mergeRosetta(getBuyerHub(), o.getBuyerHub(), this::setBuyerHub);
			merger.mergeRosetta(getSellerHub(), o.getSellerHub(), this::setSellerHub);
			
			merger.mergeBasic(getDeliveryType(), o.getDeliveryType(), this::setDeliveryType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GasDelivery _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPoint, _that.getDeliveryPoint())) return false;
			if (!Objects.equals(entryPoint, _that.getEntryPoint())) return false;
			if (!Objects.equals(withdrawalPoint, _that.getWithdrawalPoint())) return false;
			if (!Objects.equals(deliveryType, _that.getDeliveryType())) return false;
			if (!Objects.equals(interconnectionPoint, _that.getInterconnectionPoint())) return false;
			if (!Objects.equals(buyerHub, _that.getBuyerHub())) return false;
			if (!Objects.equals(sellerHub, _that.getSellerHub())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (deliveryPoint != null ? deliveryPoint.hashCode() : 0);
			_result = 31 * _result + (entryPoint != null ? entryPoint.hashCode() : 0);
			_result = 31 * _result + (withdrawalPoint != null ? withdrawalPoint.hashCode() : 0);
			_result = 31 * _result + (deliveryType != null ? deliveryType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (interconnectionPoint != null ? interconnectionPoint.hashCode() : 0);
			_result = 31 * _result + (buyerHub != null ? buyerHub.hashCode() : 0);
			_result = 31 * _result + (sellerHub != null ? sellerHub.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasDeliveryBuilder {" +
				"deliveryPoint=" + this.deliveryPoint + ", " +
				"entryPoint=" + this.entryPoint + ", " +
				"withdrawalPoint=" + this.withdrawalPoint + ", " +
				"deliveryType=" + this.deliveryType + ", " +
				"interconnectionPoint=" + this.interconnectionPoint + ", " +
				"buyerHub=" + this.buyerHub + ", " +
				"sellerHub=" + this.sellerHub +
			'}';
		}
	}
}
