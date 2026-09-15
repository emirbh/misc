package fpml.consolidated.com;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.asset.CommodityClassification;
import fpml.consolidated.com.meta.OilPhysicalLegMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Physically settled leg of a physically settled oil product transaction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Physically settled leg of a physically settled oil product transaction.
 *
 */
@RosettaDataType(value="OilPhysicalLeg", builder=OilPhysicalLeg.OilPhysicalLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OilPhysicalLeg", model="fpml", builder=OilPhysicalLeg.OilPhysicalLegBuilderImpl.class, version="2.1.1")
public interface OilPhysicalLeg extends PhysicalSwapLeg {

	OilPhysicalLegMeta metaData = new OilPhysicalLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The different options for specifying the Delivery or Supply Periods. Unless the quantity or price is to vary periodically during the trade or physical delivery occurs on a periodic basis, periodsSchedule should be used and set to 1T.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The different options for specifying the Delivery or Supply Periods. Unless the quantity or price is to vary periodically during the trade or physical delivery occurs on a periodic basis, periodsSchedule should be used and set to 1T.
	 *
	 */
	CommodityDeliveryPeriods getDeliveryPeriods();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The specification of the oil product to be delivered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The specification of the oil product to be delivered.
	 *
	 */
	OilProduct getOil();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The physical delivery conditions for the transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The physical delivery conditions for the transaction.
	 *
	 */
	OilDelivery getDeliveryConditions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The different options for specifying the quantity.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The different options for specifying the quantity.
	 *
	 */
	CommodityPhysicalQuantity getDeliveryQuantity();

	/*********************** Build Methods  ***********************/
	OilPhysicalLeg build();
	
	OilPhysicalLeg.OilPhysicalLegBuilder toBuilder();
	
	static OilPhysicalLeg.OilPhysicalLegBuilder builder() {
		return new OilPhysicalLeg.OilPhysicalLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OilPhysicalLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OilPhysicalLeg> getType() {
		return OilPhysicalLeg.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("commodityClassification"), processor, CommodityClassification.class, getCommodityClassification());
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("deliveryPeriods"), processor, CommodityDeliveryPeriods.class, getDeliveryPeriods());
		processRosetta(path.newSubPath("oil"), processor, OilProduct.class, getOil());
		processRosetta(path.newSubPath("deliveryConditions"), processor, OilDelivery.class, getDeliveryConditions());
		processRosetta(path.newSubPath("deliveryQuantity"), processor, CommodityPhysicalQuantity.class, getDeliveryQuantity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OilPhysicalLegBuilder extends OilPhysicalLeg, PhysicalSwapLeg.PhysicalSwapLegBuilder {
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder getOrCreateDeliveryPeriods();
		@Override
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder getDeliveryPeriods();
		OilProduct.OilProductBuilder getOrCreateOil();
		@Override
		OilProduct.OilProductBuilder getOil();
		OilDelivery.OilDeliveryBuilder getOrCreateDeliveryConditions();
		@Override
		OilDelivery.OilDeliveryBuilder getDeliveryConditions();
		CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder getOrCreateDeliveryQuantity();
		@Override
		CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder getDeliveryQuantity();
		@Override
		OilPhysicalLeg.OilPhysicalLegBuilder setId(String id);
		@Override
		OilPhysicalLeg.OilPhysicalLegBuilder addCommodityClassification(CommodityClassification commodityClassification);
		@Override
		OilPhysicalLeg.OilPhysicalLegBuilder addCommodityClassification(CommodityClassification commodityClassification, int idx);
		@Override
		OilPhysicalLeg.OilPhysicalLegBuilder addCommodityClassification(List<? extends CommodityClassification> commodityClassification);
		@Override
		OilPhysicalLeg.OilPhysicalLegBuilder setCommodityClassification(List<? extends CommodityClassification> commodityClassification);
		@Override
		OilPhysicalLeg.OilPhysicalLegBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		OilPhysicalLeg.OilPhysicalLegBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		OilPhysicalLeg.OilPhysicalLegBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		OilPhysicalLeg.OilPhysicalLegBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		OilPhysicalLeg.OilPhysicalLegBuilder setDeliveryPeriods(CommodityDeliveryPeriods deliveryPeriods);
		OilPhysicalLeg.OilPhysicalLegBuilder setOil(OilProduct oil);
		OilPhysicalLeg.OilPhysicalLegBuilder setDeliveryConditions(OilDelivery deliveryConditions);
		OilPhysicalLeg.OilPhysicalLegBuilder setDeliveryQuantity(CommodityPhysicalQuantity deliveryQuantity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("commodityClassification"), processor, CommodityClassification.CommodityClassificationBuilder.class, getCommodityClassification());
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("deliveryPeriods"), processor, CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder.class, getDeliveryPeriods());
			processRosetta(path.newSubPath("oil"), processor, OilProduct.OilProductBuilder.class, getOil());
			processRosetta(path.newSubPath("deliveryConditions"), processor, OilDelivery.OilDeliveryBuilder.class, getDeliveryConditions());
			processRosetta(path.newSubPath("deliveryQuantity"), processor, CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder.class, getDeliveryQuantity());
		}
		

		OilPhysicalLeg.OilPhysicalLegBuilder prune();
	}

	/*********************** Immutable Implementation of OilPhysicalLeg  ***********************/
	class OilPhysicalLegImpl extends PhysicalSwapLeg.PhysicalSwapLegImpl implements OilPhysicalLeg {
		private final CommodityDeliveryPeriods deliveryPeriods;
		private final OilProduct oil;
		private final OilDelivery deliveryConditions;
		private final CommodityPhysicalQuantity deliveryQuantity;
		
		protected OilPhysicalLegImpl(OilPhysicalLeg.OilPhysicalLegBuilder builder) {
			super(builder);
			this.deliveryPeriods = ofNullable(builder.getDeliveryPeriods()).map(f->f.build()).orElse(null);
			this.oil = ofNullable(builder.getOil()).map(f->f.build()).orElse(null);
			this.deliveryConditions = ofNullable(builder.getDeliveryConditions()).map(f->f.build()).orElse(null);
			this.deliveryQuantity = ofNullable(builder.getDeliveryQuantity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("deliveryPeriods")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryPeriods")
		public CommodityDeliveryPeriods getDeliveryPeriods() {
			return deliveryPeriods;
		}
		
		@Override
		@RosettaAttribute("oil")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("oil")
		public OilProduct getOil() {
			return oil;
		}
		
		@Override
		@RosettaAttribute("deliveryConditions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryConditions")
		public OilDelivery getDeliveryConditions() {
			return deliveryConditions;
		}
		
		@Override
		@RosettaAttribute("deliveryQuantity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("deliveryQuantity")
		public CommodityPhysicalQuantity getDeliveryQuantity() {
			return deliveryQuantity;
		}
		
		@Override
		public OilPhysicalLeg build() {
			return this;
		}
		
		@Override
		public OilPhysicalLeg.OilPhysicalLegBuilder toBuilder() {
			OilPhysicalLeg.OilPhysicalLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OilPhysicalLeg.OilPhysicalLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDeliveryPeriods()).ifPresent(builder::setDeliveryPeriods);
			ofNullable(getOil()).ifPresent(builder::setOil);
			ofNullable(getDeliveryConditions()).ifPresent(builder::setDeliveryConditions);
			ofNullable(getDeliveryQuantity()).ifPresent(builder::setDeliveryQuantity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OilPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPeriods, _that.getDeliveryPeriods())) return false;
			if (!Objects.equals(oil, _that.getOil())) return false;
			if (!Objects.equals(deliveryConditions, _that.getDeliveryConditions())) return false;
			if (!Objects.equals(deliveryQuantity, _that.getDeliveryQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deliveryPeriods != null ? deliveryPeriods.hashCode() : 0);
			_result = 31 * _result + (oil != null ? oil.hashCode() : 0);
			_result = 31 * _result + (deliveryConditions != null ? deliveryConditions.hashCode() : 0);
			_result = 31 * _result + (deliveryQuantity != null ? deliveryQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OilPhysicalLeg {" +
				"deliveryPeriods=" + this.deliveryPeriods + ", " +
				"oil=" + this.oil + ", " +
				"deliveryConditions=" + this.deliveryConditions + ", " +
				"deliveryQuantity=" + this.deliveryQuantity +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of OilPhysicalLeg  ***********************/
	class OilPhysicalLegBuilderImpl extends PhysicalSwapLeg.PhysicalSwapLegBuilderImpl implements OilPhysicalLeg.OilPhysicalLegBuilder {
	
		protected CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder deliveryPeriods;
		protected OilProduct.OilProductBuilder oil;
		protected OilDelivery.OilDeliveryBuilder deliveryConditions;
		protected CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder deliveryQuantity;
		
		@Override
		@RosettaAttribute("deliveryPeriods")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryPeriods")
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder getDeliveryPeriods() {
			return deliveryPeriods;
		}
		
		@Override
		public CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder getOrCreateDeliveryPeriods() {
			CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder result;
			if (deliveryPeriods!=null) {
				result = deliveryPeriods;
			}
			else {
				result = deliveryPeriods = CommodityDeliveryPeriods.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("oil")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("oil")
		public OilProduct.OilProductBuilder getOil() {
			return oil;
		}
		
		@Override
		public OilProduct.OilProductBuilder getOrCreateOil() {
			OilProduct.OilProductBuilder result;
			if (oil!=null) {
				result = oil;
			}
			else {
				result = oil = OilProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryConditions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryConditions")
		public OilDelivery.OilDeliveryBuilder getDeliveryConditions() {
			return deliveryConditions;
		}
		
		@Override
		public OilDelivery.OilDeliveryBuilder getOrCreateDeliveryConditions() {
			OilDelivery.OilDeliveryBuilder result;
			if (deliveryConditions!=null) {
				result = deliveryConditions;
			}
			else {
				result = deliveryConditions = OilDelivery.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryQuantity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("deliveryQuantity")
		public CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder getDeliveryQuantity() {
			return deliveryQuantity;
		}
		
		@Override
		public CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder getOrCreateDeliveryQuantity() {
			CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder result;
			if (deliveryQuantity!=null) {
				result = deliveryQuantity;
			}
			else {
				result = deliveryQuantity = CommodityPhysicalQuantity.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public OilPhysicalLeg.OilPhysicalLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("commodityClassification")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("commodityClassification")
		@Override
		public OilPhysicalLeg.OilPhysicalLegBuilder addCommodityClassification(CommodityClassification _commodityClassification) {
			if (_commodityClassification != null) {
				this.commodityClassification.add(_commodityClassification.toBuilder());
			}
			return this;
		}
		
		@Override
		public OilPhysicalLeg.OilPhysicalLegBuilder addCommodityClassification(CommodityClassification _commodityClassification, int idx) {
			getIndex(this.commodityClassification, idx, () -> _commodityClassification.toBuilder());
			return this;
		}
		
		@Override
		public OilPhysicalLeg.OilPhysicalLegBuilder addCommodityClassification(List<? extends CommodityClassification> commodityClassifications) {
			if (commodityClassifications != null) {
				for (final CommodityClassification toAdd : commodityClassifications) {
					this.commodityClassification.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("commodityClassification")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("commodityClassification")
		@Override
		public OilPhysicalLeg.OilPhysicalLegBuilder setCommodityClassification(List<? extends CommodityClassification> commodityClassifications) {
			if (commodityClassifications == null) {
				this.commodityClassification = new ArrayList<>();
			} else {
				this.commodityClassification = commodityClassifications.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public OilPhysicalLeg.OilPhysicalLegBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public OilPhysicalLeg.OilPhysicalLegBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public OilPhysicalLeg.OilPhysicalLegBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public OilPhysicalLeg.OilPhysicalLegBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryPeriods")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryPeriods")
		@Override
		public OilPhysicalLeg.OilPhysicalLegBuilder setDeliveryPeriods(CommodityDeliveryPeriods _deliveryPeriods) {
			this.deliveryPeriods = _deliveryPeriods == null ? null : _deliveryPeriods.toBuilder();
			return this;
		}
		
		@RosettaAttribute("oil")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("oil")
		@Override
		public OilPhysicalLeg.OilPhysicalLegBuilder setOil(OilProduct _oil) {
			this.oil = _oil == null ? null : _oil.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryConditions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryConditions")
		@Override
		public OilPhysicalLeg.OilPhysicalLegBuilder setDeliveryConditions(OilDelivery _deliveryConditions) {
			this.deliveryConditions = _deliveryConditions == null ? null : _deliveryConditions.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryQuantity")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("deliveryQuantity")
		@Override
		public OilPhysicalLeg.OilPhysicalLegBuilder setDeliveryQuantity(CommodityPhysicalQuantity _deliveryQuantity) {
			this.deliveryQuantity = _deliveryQuantity == null ? null : _deliveryQuantity.toBuilder();
			return this;
		}
		
		@Override
		public OilPhysicalLeg build() {
			return new OilPhysicalLeg.OilPhysicalLegImpl(this);
		}
		
		@Override
		public OilPhysicalLeg.OilPhysicalLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OilPhysicalLeg.OilPhysicalLegBuilder prune() {
			super.prune();
			if (deliveryPeriods!=null && !deliveryPeriods.prune().hasData()) deliveryPeriods = null;
			if (oil!=null && !oil.prune().hasData()) oil = null;
			if (deliveryConditions!=null && !deliveryConditions.prune().hasData()) deliveryConditions = null;
			if (deliveryQuantity!=null && !deliveryQuantity.prune().hasData()) deliveryQuantity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDeliveryPeriods()!=null && getDeliveryPeriods().hasData()) return true;
			if (getOil()!=null && getOil().hasData()) return true;
			if (getDeliveryConditions()!=null && getDeliveryConditions().hasData()) return true;
			if (getDeliveryQuantity()!=null && getDeliveryQuantity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OilPhysicalLeg.OilPhysicalLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			OilPhysicalLeg.OilPhysicalLegBuilder o = (OilPhysicalLeg.OilPhysicalLegBuilder) other;
			
			merger.mergeRosetta(getDeliveryPeriods(), o.getDeliveryPeriods(), this::setDeliveryPeriods);
			merger.mergeRosetta(getOil(), o.getOil(), this::setOil);
			merger.mergeRosetta(getDeliveryConditions(), o.getDeliveryConditions(), this::setDeliveryConditions);
			merger.mergeRosetta(getDeliveryQuantity(), o.getDeliveryQuantity(), this::setDeliveryQuantity);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			OilPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPeriods, _that.getDeliveryPeriods())) return false;
			if (!Objects.equals(oil, _that.getOil())) return false;
			if (!Objects.equals(deliveryConditions, _that.getDeliveryConditions())) return false;
			if (!Objects.equals(deliveryQuantity, _that.getDeliveryQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deliveryPeriods != null ? deliveryPeriods.hashCode() : 0);
			_result = 31 * _result + (oil != null ? oil.hashCode() : 0);
			_result = 31 * _result + (deliveryConditions != null ? deliveryConditions.hashCode() : 0);
			_result = 31 * _result + (deliveryQuantity != null ? deliveryQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OilPhysicalLegBuilder {" +
				"deliveryPeriods=" + this.deliveryPeriods + ", " +
				"oil=" + this.oil + ", " +
				"deliveryConditions=" + this.deliveryConditions + ", " +
				"deliveryQuantity=" + this.deliveryQuantity +
			'}' + " " + super.toString();
		}
	}
}
