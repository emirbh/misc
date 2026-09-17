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
import fpml.consolidated.com.meta.GasPhysicalLegMeta;
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
 * Provision Physically settled leg of a physically settled gas transaction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Physically settled leg of a physically settled gas transaction.
 *
 */
@RosettaDataType(value="GasPhysicalLeg", builder=GasPhysicalLeg.GasPhysicalLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="GasPhysicalLeg", model="fpml", builder=GasPhysicalLeg.GasPhysicalLegBuilderImpl.class, version="2.1.1")
public interface GasPhysicalLeg extends PhysicalSwapLeg {

	GasPhysicalLegMeta metaData = new GasPhysicalLegMeta();

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
	GasDeliveryPeriods getDeliveryPeriods();
	/**
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
	GasProduct getGas();
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
	GasDelivery getDeliveryConditions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The different options for specifying the quantity. For Fixed trades where the quantity is known at the time of confirmation, a single quantity or a quantity per Delivery Period may be specified. For Variable trades minimum and maximum trades may be specified.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The different options for specifying the quantity. For Fixed trades where the quantity is known at the time of confirmation, a single quantity or a quantity per Delivery Period may be specified. For Variable trades minimum and maximum trades may be specified.
	 *
	 */
	GasPhysicalQuantity getDeliveryQuantity();

	/*********************** Build Methods  ***********************/
	GasPhysicalLeg build();
	
	GasPhysicalLeg.GasPhysicalLegBuilder toBuilder();
	
	static GasPhysicalLeg.GasPhysicalLegBuilder builder() {
		return new GasPhysicalLeg.GasPhysicalLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GasPhysicalLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GasPhysicalLeg> getType() {
		return GasPhysicalLeg.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("commodityClassification"), processor, CommodityClassification.class, getCommodityClassification());
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("deliveryPeriods"), processor, GasDeliveryPeriods.class, getDeliveryPeriods());
		processRosetta(path.newSubPath("gas"), processor, GasProduct.class, getGas());
		processRosetta(path.newSubPath("deliveryConditions"), processor, GasDelivery.class, getDeliveryConditions());
		processRosetta(path.newSubPath("deliveryQuantity"), processor, GasPhysicalQuantity.class, getDeliveryQuantity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GasPhysicalLegBuilder extends GasPhysicalLeg, PhysicalSwapLeg.PhysicalSwapLegBuilder {
		GasDeliveryPeriods.GasDeliveryPeriodsBuilder getOrCreateDeliveryPeriods();
		@Override
		GasDeliveryPeriods.GasDeliveryPeriodsBuilder getDeliveryPeriods();
		GasProduct.GasProductBuilder getOrCreateGas();
		@Override
		GasProduct.GasProductBuilder getGas();
		GasDelivery.GasDeliveryBuilder getOrCreateDeliveryConditions();
		@Override
		GasDelivery.GasDeliveryBuilder getDeliveryConditions();
		GasPhysicalQuantity.GasPhysicalQuantityBuilder getOrCreateDeliveryQuantity();
		@Override
		GasPhysicalQuantity.GasPhysicalQuantityBuilder getDeliveryQuantity();
		@Override
		GasPhysicalLeg.GasPhysicalLegBuilder setId(String id);
		@Override
		GasPhysicalLeg.GasPhysicalLegBuilder addCommodityClassification(CommodityClassification commodityClassification);
		@Override
		GasPhysicalLeg.GasPhysicalLegBuilder addCommodityClassification(CommodityClassification commodityClassification, int idx);
		@Override
		GasPhysicalLeg.GasPhysicalLegBuilder addCommodityClassification(List<? extends CommodityClassification> commodityClassification);
		@Override
		GasPhysicalLeg.GasPhysicalLegBuilder setCommodityClassification(List<? extends CommodityClassification> commodityClassification);
		@Override
		GasPhysicalLeg.GasPhysicalLegBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		GasPhysicalLeg.GasPhysicalLegBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		GasPhysicalLeg.GasPhysicalLegBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		GasPhysicalLeg.GasPhysicalLegBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		GasPhysicalLeg.GasPhysicalLegBuilder setDeliveryPeriods(GasDeliveryPeriods deliveryPeriods);
		GasPhysicalLeg.GasPhysicalLegBuilder setGas(GasProduct gas);
		GasPhysicalLeg.GasPhysicalLegBuilder setDeliveryConditions(GasDelivery deliveryConditions);
		GasPhysicalLeg.GasPhysicalLegBuilder setDeliveryQuantity(GasPhysicalQuantity deliveryQuantity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("commodityClassification"), processor, CommodityClassification.CommodityClassificationBuilder.class, getCommodityClassification());
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("deliveryPeriods"), processor, GasDeliveryPeriods.GasDeliveryPeriodsBuilder.class, getDeliveryPeriods());
			processRosetta(path.newSubPath("gas"), processor, GasProduct.GasProductBuilder.class, getGas());
			processRosetta(path.newSubPath("deliveryConditions"), processor, GasDelivery.GasDeliveryBuilder.class, getDeliveryConditions());
			processRosetta(path.newSubPath("deliveryQuantity"), processor, GasPhysicalQuantity.GasPhysicalQuantityBuilder.class, getDeliveryQuantity());
		}
		

		GasPhysicalLeg.GasPhysicalLegBuilder prune();
	}

	/*********************** Immutable Implementation of GasPhysicalLeg  ***********************/
	class GasPhysicalLegImpl extends PhysicalSwapLeg.PhysicalSwapLegImpl implements GasPhysicalLeg {
		private final GasDeliveryPeriods deliveryPeriods;
		private final GasProduct gas;
		private final GasDelivery deliveryConditions;
		private final GasPhysicalQuantity deliveryQuantity;
		
		protected GasPhysicalLegImpl(GasPhysicalLeg.GasPhysicalLegBuilder builder) {
			super(builder);
			this.deliveryPeriods = ofNullable(builder.getDeliveryPeriods()).map(f->f.build()).orElse(null);
			this.gas = ofNullable(builder.getGas()).map(f->f.build()).orElse(null);
			this.deliveryConditions = ofNullable(builder.getDeliveryConditions()).map(f->f.build()).orElse(null);
			this.deliveryQuantity = ofNullable(builder.getDeliveryQuantity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("deliveryPeriods")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("deliveryPeriods")
		public GasDeliveryPeriods getDeliveryPeriods() {
			return deliveryPeriods;
		}
		
		@Override
		@RosettaAttribute("gas")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("gas")
		public GasProduct getGas() {
			return gas;
		}
		
		@Override
		@RosettaAttribute("deliveryConditions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryConditions")
		public GasDelivery getDeliveryConditions() {
			return deliveryConditions;
		}
		
		@Override
		@RosettaAttribute("deliveryQuantity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("deliveryQuantity")
		public GasPhysicalQuantity getDeliveryQuantity() {
			return deliveryQuantity;
		}
		
		@Override
		public GasPhysicalLeg build() {
			return this;
		}
		
		@Override
		public GasPhysicalLeg.GasPhysicalLegBuilder toBuilder() {
			GasPhysicalLeg.GasPhysicalLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GasPhysicalLeg.GasPhysicalLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDeliveryPeriods()).ifPresent(builder::setDeliveryPeriods);
			ofNullable(getGas()).ifPresent(builder::setGas);
			ofNullable(getDeliveryConditions()).ifPresent(builder::setDeliveryConditions);
			ofNullable(getDeliveryQuantity()).ifPresent(builder::setDeliveryQuantity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GasPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPeriods, _that.getDeliveryPeriods())) return false;
			if (!Objects.equals(gas, _that.getGas())) return false;
			if (!Objects.equals(deliveryConditions, _that.getDeliveryConditions())) return false;
			if (!Objects.equals(deliveryQuantity, _that.getDeliveryQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deliveryPeriods != null ? deliveryPeriods.hashCode() : 0);
			_result = 31 * _result + (gas != null ? gas.hashCode() : 0);
			_result = 31 * _result + (deliveryConditions != null ? deliveryConditions.hashCode() : 0);
			_result = 31 * _result + (deliveryQuantity != null ? deliveryQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasPhysicalLeg {" +
				"deliveryPeriods=" + this.deliveryPeriods + ", " +
				"gas=" + this.gas + ", " +
				"deliveryConditions=" + this.deliveryConditions + ", " +
				"deliveryQuantity=" + this.deliveryQuantity +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of GasPhysicalLeg  ***********************/
	class GasPhysicalLegBuilderImpl extends PhysicalSwapLeg.PhysicalSwapLegBuilderImpl implements GasPhysicalLeg.GasPhysicalLegBuilder {
	
		protected GasDeliveryPeriods.GasDeliveryPeriodsBuilder deliveryPeriods;
		protected GasProduct.GasProductBuilder gas;
		protected GasDelivery.GasDeliveryBuilder deliveryConditions;
		protected GasPhysicalQuantity.GasPhysicalQuantityBuilder deliveryQuantity;
		
		@Override
		@RosettaAttribute("deliveryPeriods")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("deliveryPeriods")
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder getDeliveryPeriods() {
			return deliveryPeriods;
		}
		
		@Override
		public GasDeliveryPeriods.GasDeliveryPeriodsBuilder getOrCreateDeliveryPeriods() {
			GasDeliveryPeriods.GasDeliveryPeriodsBuilder result;
			if (deliveryPeriods!=null) {
				result = deliveryPeriods;
			}
			else {
				result = deliveryPeriods = GasDeliveryPeriods.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("gas")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("gas")
		public GasProduct.GasProductBuilder getGas() {
			return gas;
		}
		
		@Override
		public GasProduct.GasProductBuilder getOrCreateGas() {
			GasProduct.GasProductBuilder result;
			if (gas!=null) {
				result = gas;
			}
			else {
				result = gas = GasProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryConditions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryConditions")
		public GasDelivery.GasDeliveryBuilder getDeliveryConditions() {
			return deliveryConditions;
		}
		
		@Override
		public GasDelivery.GasDeliveryBuilder getOrCreateDeliveryConditions() {
			GasDelivery.GasDeliveryBuilder result;
			if (deliveryConditions!=null) {
				result = deliveryConditions;
			}
			else {
				result = deliveryConditions = GasDelivery.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryQuantity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("deliveryQuantity")
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder getDeliveryQuantity() {
			return deliveryQuantity;
		}
		
		@Override
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder getOrCreateDeliveryQuantity() {
			GasPhysicalQuantity.GasPhysicalQuantityBuilder result;
			if (deliveryQuantity!=null) {
				result = deliveryQuantity;
			}
			else {
				result = deliveryQuantity = GasPhysicalQuantity.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public GasPhysicalLeg.GasPhysicalLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("commodityClassification")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("commodityClassification")
		@Override
		public GasPhysicalLeg.GasPhysicalLegBuilder addCommodityClassification(CommodityClassification _commodityClassification) {
			if (_commodityClassification != null) {
				this.commodityClassification.add(_commodityClassification.toBuilder());
			}
			return this;
		}
		
		@Override
		public GasPhysicalLeg.GasPhysicalLegBuilder addCommodityClassification(CommodityClassification _commodityClassification, int idx) {
			getIndex(this.commodityClassification, idx, () -> _commodityClassification.toBuilder());
			return this;
		}
		
		@Override
		public GasPhysicalLeg.GasPhysicalLegBuilder addCommodityClassification(List<? extends CommodityClassification> commodityClassifications) {
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
		public GasPhysicalLeg.GasPhysicalLegBuilder setCommodityClassification(List<? extends CommodityClassification> commodityClassifications) {
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
		public GasPhysicalLeg.GasPhysicalLegBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public GasPhysicalLeg.GasPhysicalLegBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public GasPhysicalLeg.GasPhysicalLegBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public GasPhysicalLeg.GasPhysicalLegBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryPeriods")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("deliveryPeriods")
		@Override
		public GasPhysicalLeg.GasPhysicalLegBuilder setDeliveryPeriods(GasDeliveryPeriods _deliveryPeriods) {
			this.deliveryPeriods = _deliveryPeriods == null ? null : _deliveryPeriods.toBuilder();
			return this;
		}
		
		@RosettaAttribute("gas")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("gas")
		@Override
		public GasPhysicalLeg.GasPhysicalLegBuilder setGas(GasProduct _gas) {
			this.gas = _gas == null ? null : _gas.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryConditions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryConditions")
		@Override
		public GasPhysicalLeg.GasPhysicalLegBuilder setDeliveryConditions(GasDelivery _deliveryConditions) {
			this.deliveryConditions = _deliveryConditions == null ? null : _deliveryConditions.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryQuantity")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("deliveryQuantity")
		@Override
		public GasPhysicalLeg.GasPhysicalLegBuilder setDeliveryQuantity(GasPhysicalQuantity _deliveryQuantity) {
			this.deliveryQuantity = _deliveryQuantity == null ? null : _deliveryQuantity.toBuilder();
			return this;
		}
		
		@Override
		public GasPhysicalLeg build() {
			return new GasPhysicalLeg.GasPhysicalLegImpl(this);
		}
		
		@Override
		public GasPhysicalLeg.GasPhysicalLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasPhysicalLeg.GasPhysicalLegBuilder prune() {
			super.prune();
			if (deliveryPeriods!=null && !deliveryPeriods.prune().hasData()) deliveryPeriods = null;
			if (gas!=null && !gas.prune().hasData()) gas = null;
			if (deliveryConditions!=null && !deliveryConditions.prune().hasData()) deliveryConditions = null;
			if (deliveryQuantity!=null && !deliveryQuantity.prune().hasData()) deliveryQuantity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDeliveryPeriods()!=null && getDeliveryPeriods().hasData()) return true;
			if (getGas()!=null && getGas().hasData()) return true;
			if (getDeliveryConditions()!=null && getDeliveryConditions().hasData()) return true;
			if (getDeliveryQuantity()!=null && getDeliveryQuantity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasPhysicalLeg.GasPhysicalLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			GasPhysicalLeg.GasPhysicalLegBuilder o = (GasPhysicalLeg.GasPhysicalLegBuilder) other;
			
			merger.mergeRosetta(getDeliveryPeriods(), o.getDeliveryPeriods(), this::setDeliveryPeriods);
			merger.mergeRosetta(getGas(), o.getGas(), this::setGas);
			merger.mergeRosetta(getDeliveryConditions(), o.getDeliveryConditions(), this::setDeliveryConditions);
			merger.mergeRosetta(getDeliveryQuantity(), o.getDeliveryQuantity(), this::setDeliveryQuantity);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GasPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPeriods, _that.getDeliveryPeriods())) return false;
			if (!Objects.equals(gas, _that.getGas())) return false;
			if (!Objects.equals(deliveryConditions, _that.getDeliveryConditions())) return false;
			if (!Objects.equals(deliveryQuantity, _that.getDeliveryQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deliveryPeriods != null ? deliveryPeriods.hashCode() : 0);
			_result = 31 * _result + (gas != null ? gas.hashCode() : 0);
			_result = 31 * _result + (deliveryConditions != null ? deliveryConditions.hashCode() : 0);
			_result = 31 * _result + (deliveryQuantity != null ? deliveryQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasPhysicalLegBuilder {" +
				"deliveryPeriods=" + this.deliveryPeriods + ", " +
				"gas=" + this.gas + ", " +
				"deliveryConditions=" + this.deliveryConditions + ", " +
				"deliveryQuantity=" + this.deliveryQuantity +
			'}' + " " + super.toString();
		}
	}
}
