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
import fpml.consolidated.com.meta.MetalPhysicalLegMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import java.math.BigDecimal;
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
 * Provision Physically settled leg of a physically settled Metal transaction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Physically settled leg of a physically settled Metal transaction.
 *
 */
@RosettaDataType(value="MetalPhysicalLeg", builder=MetalPhysicalLeg.MetalPhysicalLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MetalPhysicalLeg", model="fpml", builder=MetalPhysicalLeg.MetalPhysicalLegBuilderImpl.class, version="2.1.1")
public interface MetalPhysicalLeg extends PhysicalForwardLeg {

	MetalPhysicalLegMeta metaData = new MetalPhysicalLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The specification of the Metal Product to be delivered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The specification of the Metal Product to be delivered.
	 *
	 */
	Metal getMetal();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The period during which delivery/deliveries of Metal may be scheduled.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The period during which delivery/deliveries of Metal may be scheduled.
	 *
	 */
	CommodityDeliveryPeriods getDeliveryPeriods();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The physical delivery arrangements and requirements for a physically settled non-precious metal transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The physical delivery arrangements and requirements for a physically settled non-precious metal transaction.
	 *
	 */
	MetalDelivery getDeliveryConditions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Quantity per Delivery Period.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Quantity per Delivery Period.
	 *
	 */
	CommodityNotionalQuantity getPhysicalQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Allows the documentation of a shaped quantity trade where the quantity changes over the life of the transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Allows the documentation of a shaped quantity trade where the quantity changes over the life of the transaction.
	 *
	 */
	CommodityPhysicalQuantitySchedule getPhysicalQuantitySchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Total Quantity of the commodity to be delivered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Total Quantity of the commodity to be delivered.
	 *
	 */
	UnitQuantity getTotalPhysicalQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If the Notional Quantity is specified in a unit that does not match the unit in which the Commodity Reference Price is quoted, the scaling or conversion factor used to convert the Commodity Reference Price unit into the Notional Quantity unit should be stated here. If there is no conversion, this element is not intended to be used.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If the Notional Quantity is specified in a unit that does not match the unit in which the Commodity Reference Price is quoted, the scaling or conversion factor used to convert the Commodity Reference Price unit into the Notional Quantity unit should be stated here. If there is no conversion, this element is not intended to be used.
	 *
	 */
	BigDecimal getConversionFactor();

	/*********************** Build Methods  ***********************/
	MetalPhysicalLeg build();
	
	MetalPhysicalLeg.MetalPhysicalLegBuilder toBuilder();
	
	static MetalPhysicalLeg.MetalPhysicalLegBuilder builder() {
		return new MetalPhysicalLeg.MetalPhysicalLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MetalPhysicalLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MetalPhysicalLeg> getType() {
		return MetalPhysicalLeg.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("commodityClassification"), processor, CommodityClassification.class, getCommodityClassification());
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("metal"), processor, Metal.class, getMetal());
		processRosetta(path.newSubPath("deliveryPeriods"), processor, CommodityDeliveryPeriods.class, getDeliveryPeriods());
		processRosetta(path.newSubPath("deliveryConditions"), processor, MetalDelivery.class, getDeliveryConditions());
		processRosetta(path.newSubPath("physicalQuantity"), processor, CommodityNotionalQuantity.class, getPhysicalQuantity());
		processRosetta(path.newSubPath("physicalQuantitySchedule"), processor, CommodityPhysicalQuantitySchedule.class, getPhysicalQuantitySchedule());
		processRosetta(path.newSubPath("totalPhysicalQuantity"), processor, UnitQuantity.class, getTotalPhysicalQuantity());
		processor.processBasic(path.newSubPath("conversionFactor"), BigDecimal.class, getConversionFactor(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MetalPhysicalLegBuilder extends MetalPhysicalLeg, PhysicalForwardLeg.PhysicalForwardLegBuilder {
		Metal.MetalBuilder getOrCreateMetal();
		@Override
		Metal.MetalBuilder getMetal();
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder getOrCreateDeliveryPeriods();
		@Override
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder getDeliveryPeriods();
		MetalDelivery.MetalDeliveryBuilder getOrCreateDeliveryConditions();
		@Override
		MetalDelivery.MetalDeliveryBuilder getDeliveryConditions();
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreatePhysicalQuantity();
		@Override
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getPhysicalQuantity();
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder getOrCreatePhysicalQuantitySchedule();
		@Override
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder getPhysicalQuantitySchedule();
		UnitQuantity.UnitQuantityBuilder getOrCreateTotalPhysicalQuantity();
		@Override
		UnitQuantity.UnitQuantityBuilder getTotalPhysicalQuantity();
		@Override
		MetalPhysicalLeg.MetalPhysicalLegBuilder setId(String id);
		@Override
		MetalPhysicalLeg.MetalPhysicalLegBuilder addCommodityClassification(CommodityClassification commodityClassification);
		@Override
		MetalPhysicalLeg.MetalPhysicalLegBuilder addCommodityClassification(CommodityClassification commodityClassification, int idx);
		@Override
		MetalPhysicalLeg.MetalPhysicalLegBuilder addCommodityClassification(List<? extends CommodityClassification> commodityClassification);
		@Override
		MetalPhysicalLeg.MetalPhysicalLegBuilder setCommodityClassification(List<? extends CommodityClassification> commodityClassification);
		@Override
		MetalPhysicalLeg.MetalPhysicalLegBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		MetalPhysicalLeg.MetalPhysicalLegBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		MetalPhysicalLeg.MetalPhysicalLegBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		MetalPhysicalLeg.MetalPhysicalLegBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		MetalPhysicalLeg.MetalPhysicalLegBuilder setMetal(Metal metal);
		MetalPhysicalLeg.MetalPhysicalLegBuilder setDeliveryPeriods(CommodityDeliveryPeriods deliveryPeriods);
		MetalPhysicalLeg.MetalPhysicalLegBuilder setDeliveryConditions(MetalDelivery deliveryConditions);
		MetalPhysicalLeg.MetalPhysicalLegBuilder setPhysicalQuantity(CommodityNotionalQuantity physicalQuantity);
		MetalPhysicalLeg.MetalPhysicalLegBuilder setPhysicalQuantitySchedule(CommodityPhysicalQuantitySchedule physicalQuantitySchedule);
		MetalPhysicalLeg.MetalPhysicalLegBuilder setTotalPhysicalQuantity(UnitQuantity totalPhysicalQuantity);
		MetalPhysicalLeg.MetalPhysicalLegBuilder setConversionFactor(BigDecimal conversionFactor);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("commodityClassification"), processor, CommodityClassification.CommodityClassificationBuilder.class, getCommodityClassification());
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("metal"), processor, Metal.MetalBuilder.class, getMetal());
			processRosetta(path.newSubPath("deliveryPeriods"), processor, CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder.class, getDeliveryPeriods());
			processRosetta(path.newSubPath("deliveryConditions"), processor, MetalDelivery.MetalDeliveryBuilder.class, getDeliveryConditions());
			processRosetta(path.newSubPath("physicalQuantity"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getPhysicalQuantity());
			processRosetta(path.newSubPath("physicalQuantitySchedule"), processor, CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder.class, getPhysicalQuantitySchedule());
			processRosetta(path.newSubPath("totalPhysicalQuantity"), processor, UnitQuantity.UnitQuantityBuilder.class, getTotalPhysicalQuantity());
			processor.processBasic(path.newSubPath("conversionFactor"), BigDecimal.class, getConversionFactor(), this);
		}
		

		MetalPhysicalLeg.MetalPhysicalLegBuilder prune();
	}

	/*********************** Immutable Implementation of MetalPhysicalLeg  ***********************/
	class MetalPhysicalLegImpl extends PhysicalForwardLeg.PhysicalForwardLegImpl implements MetalPhysicalLeg {
		private final Metal metal;
		private final CommodityDeliveryPeriods deliveryPeriods;
		private final MetalDelivery deliveryConditions;
		private final CommodityNotionalQuantity physicalQuantity;
		private final CommodityPhysicalQuantitySchedule physicalQuantitySchedule;
		private final UnitQuantity totalPhysicalQuantity;
		private final BigDecimal conversionFactor;
		
		protected MetalPhysicalLegImpl(MetalPhysicalLeg.MetalPhysicalLegBuilder builder) {
			super(builder);
			this.metal = ofNullable(builder.getMetal()).map(f->f.build()).orElse(null);
			this.deliveryPeriods = ofNullable(builder.getDeliveryPeriods()).map(f->f.build()).orElse(null);
			this.deliveryConditions = ofNullable(builder.getDeliveryConditions()).map(f->f.build()).orElse(null);
			this.physicalQuantity = ofNullable(builder.getPhysicalQuantity()).map(f->f.build()).orElse(null);
			this.physicalQuantitySchedule = ofNullable(builder.getPhysicalQuantitySchedule()).map(f->f.build()).orElse(null);
			this.totalPhysicalQuantity = ofNullable(builder.getTotalPhysicalQuantity()).map(f->f.build()).orElse(null);
			this.conversionFactor = builder.getConversionFactor();
		}
		
		@Override
		@RosettaAttribute("metal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("metal")
		public Metal getMetal() {
			return metal;
		}
		
		@Override
		@RosettaAttribute("deliveryPeriods")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryPeriods")
		public CommodityDeliveryPeriods getDeliveryPeriods() {
			return deliveryPeriods;
		}
		
		@Override
		@RosettaAttribute("deliveryConditions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryConditions")
		public MetalDelivery getDeliveryConditions() {
			return deliveryConditions;
		}
		
		@Override
		@RosettaAttribute("physicalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalQuantity")
		public CommodityNotionalQuantity getPhysicalQuantity() {
			return physicalQuantity;
		}
		
		@Override
		@RosettaAttribute("physicalQuantitySchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalQuantitySchedule")
		public CommodityPhysicalQuantitySchedule getPhysicalQuantitySchedule() {
			return physicalQuantitySchedule;
		}
		
		@Override
		@RosettaAttribute("totalPhysicalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("totalPhysicalQuantity")
		public UnitQuantity getTotalPhysicalQuantity() {
			return totalPhysicalQuantity;
		}
		
		@Override
		@RosettaAttribute("conversionFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("conversionFactor")
		public BigDecimal getConversionFactor() {
			return conversionFactor;
		}
		
		@Override
		public MetalPhysicalLeg build() {
			return this;
		}
		
		@Override
		public MetalPhysicalLeg.MetalPhysicalLegBuilder toBuilder() {
			MetalPhysicalLeg.MetalPhysicalLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MetalPhysicalLeg.MetalPhysicalLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMetal()).ifPresent(builder::setMetal);
			ofNullable(getDeliveryPeriods()).ifPresent(builder::setDeliveryPeriods);
			ofNullable(getDeliveryConditions()).ifPresent(builder::setDeliveryConditions);
			ofNullable(getPhysicalQuantity()).ifPresent(builder::setPhysicalQuantity);
			ofNullable(getPhysicalQuantitySchedule()).ifPresent(builder::setPhysicalQuantitySchedule);
			ofNullable(getTotalPhysicalQuantity()).ifPresent(builder::setTotalPhysicalQuantity);
			ofNullable(getConversionFactor()).ifPresent(builder::setConversionFactor);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MetalPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(metal, _that.getMetal())) return false;
			if (!Objects.equals(deliveryPeriods, _that.getDeliveryPeriods())) return false;
			if (!Objects.equals(deliveryConditions, _that.getDeliveryConditions())) return false;
			if (!Objects.equals(physicalQuantity, _that.getPhysicalQuantity())) return false;
			if (!Objects.equals(physicalQuantitySchedule, _that.getPhysicalQuantitySchedule())) return false;
			if (!Objects.equals(totalPhysicalQuantity, _that.getTotalPhysicalQuantity())) return false;
			if (!Objects.equals(conversionFactor, _that.getConversionFactor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (metal != null ? metal.hashCode() : 0);
			_result = 31 * _result + (deliveryPeriods != null ? deliveryPeriods.hashCode() : 0);
			_result = 31 * _result + (deliveryConditions != null ? deliveryConditions.hashCode() : 0);
			_result = 31 * _result + (physicalQuantity != null ? physicalQuantity.hashCode() : 0);
			_result = 31 * _result + (physicalQuantitySchedule != null ? physicalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (totalPhysicalQuantity != null ? totalPhysicalQuantity.hashCode() : 0);
			_result = 31 * _result + (conversionFactor != null ? conversionFactor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MetalPhysicalLeg {" +
				"metal=" + this.metal + ", " +
				"deliveryPeriods=" + this.deliveryPeriods + ", " +
				"deliveryConditions=" + this.deliveryConditions + ", " +
				"physicalQuantity=" + this.physicalQuantity + ", " +
				"physicalQuantitySchedule=" + this.physicalQuantitySchedule + ", " +
				"totalPhysicalQuantity=" + this.totalPhysicalQuantity + ", " +
				"conversionFactor=" + this.conversionFactor +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MetalPhysicalLeg  ***********************/
	class MetalPhysicalLegBuilderImpl extends PhysicalForwardLeg.PhysicalForwardLegBuilderImpl implements MetalPhysicalLeg.MetalPhysicalLegBuilder {
	
		protected Metal.MetalBuilder metal;
		protected CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder deliveryPeriods;
		protected MetalDelivery.MetalDeliveryBuilder deliveryConditions;
		protected CommodityNotionalQuantity.CommodityNotionalQuantityBuilder physicalQuantity;
		protected CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder physicalQuantitySchedule;
		protected UnitQuantity.UnitQuantityBuilder totalPhysicalQuantity;
		protected BigDecimal conversionFactor;
		
		@Override
		@RosettaAttribute("metal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("metal")
		public Metal.MetalBuilder getMetal() {
			return metal;
		}
		
		@Override
		public Metal.MetalBuilder getOrCreateMetal() {
			Metal.MetalBuilder result;
			if (metal!=null) {
				result = metal;
			}
			else {
				result = metal = Metal.builder();
			}
			
			return result;
		}
		
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
		@RosettaAttribute("deliveryConditions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryConditions")
		public MetalDelivery.MetalDeliveryBuilder getDeliveryConditions() {
			return deliveryConditions;
		}
		
		@Override
		public MetalDelivery.MetalDeliveryBuilder getOrCreateDeliveryConditions() {
			MetalDelivery.MetalDeliveryBuilder result;
			if (deliveryConditions!=null) {
				result = deliveryConditions;
			}
			else {
				result = deliveryConditions = MetalDelivery.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("physicalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalQuantity")
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getPhysicalQuantity() {
			return physicalQuantity;
		}
		
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreatePhysicalQuantity() {
			CommodityNotionalQuantity.CommodityNotionalQuantityBuilder result;
			if (physicalQuantity!=null) {
				result = physicalQuantity;
			}
			else {
				result = physicalQuantity = CommodityNotionalQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("physicalQuantitySchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalQuantitySchedule")
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder getPhysicalQuantitySchedule() {
			return physicalQuantitySchedule;
		}
		
		@Override
		public CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder getOrCreatePhysicalQuantitySchedule() {
			CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder result;
			if (physicalQuantitySchedule!=null) {
				result = physicalQuantitySchedule;
			}
			else {
				result = physicalQuantitySchedule = CommodityPhysicalQuantitySchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("totalPhysicalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("totalPhysicalQuantity")
		public UnitQuantity.UnitQuantityBuilder getTotalPhysicalQuantity() {
			return totalPhysicalQuantity;
		}
		
		@Override
		public UnitQuantity.UnitQuantityBuilder getOrCreateTotalPhysicalQuantity() {
			UnitQuantity.UnitQuantityBuilder result;
			if (totalPhysicalQuantity!=null) {
				result = totalPhysicalQuantity;
			}
			else {
				result = totalPhysicalQuantity = UnitQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("conversionFactor")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("conversionFactor")
		public BigDecimal getConversionFactor() {
			return conversionFactor;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public MetalPhysicalLeg.MetalPhysicalLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("commodityClassification")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("commodityClassification")
		@Override
		public MetalPhysicalLeg.MetalPhysicalLegBuilder addCommodityClassification(CommodityClassification _commodityClassification) {
			if (_commodityClassification != null) {
				this.commodityClassification.add(_commodityClassification.toBuilder());
			}
			return this;
		}
		
		@Override
		public MetalPhysicalLeg.MetalPhysicalLegBuilder addCommodityClassification(CommodityClassification _commodityClassification, int idx) {
			getIndex(this.commodityClassification, idx, () -> _commodityClassification.toBuilder());
			return this;
		}
		
		@Override
		public MetalPhysicalLeg.MetalPhysicalLegBuilder addCommodityClassification(List<? extends CommodityClassification> commodityClassifications) {
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
		public MetalPhysicalLeg.MetalPhysicalLegBuilder setCommodityClassification(List<? extends CommodityClassification> commodityClassifications) {
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
		public MetalPhysicalLeg.MetalPhysicalLegBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public MetalPhysicalLeg.MetalPhysicalLegBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public MetalPhysicalLeg.MetalPhysicalLegBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public MetalPhysicalLeg.MetalPhysicalLegBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("metal")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("metal")
		@Override
		public MetalPhysicalLeg.MetalPhysicalLegBuilder setMetal(Metal _metal) {
			this.metal = _metal == null ? null : _metal.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryPeriods")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryPeriods")
		@Override
		public MetalPhysicalLeg.MetalPhysicalLegBuilder setDeliveryPeriods(CommodityDeliveryPeriods _deliveryPeriods) {
			this.deliveryPeriods = _deliveryPeriods == null ? null : _deliveryPeriods.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryConditions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryConditions")
		@Override
		public MetalPhysicalLeg.MetalPhysicalLegBuilder setDeliveryConditions(MetalDelivery _deliveryConditions) {
			this.deliveryConditions = _deliveryConditions == null ? null : _deliveryConditions.toBuilder();
			return this;
		}
		
		@RosettaAttribute("physicalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("physicalQuantity")
		@Override
		public MetalPhysicalLeg.MetalPhysicalLegBuilder setPhysicalQuantity(CommodityNotionalQuantity _physicalQuantity) {
			this.physicalQuantity = _physicalQuantity == null ? null : _physicalQuantity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("physicalQuantitySchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("physicalQuantitySchedule")
		@Override
		public MetalPhysicalLeg.MetalPhysicalLegBuilder setPhysicalQuantitySchedule(CommodityPhysicalQuantitySchedule _physicalQuantitySchedule) {
			this.physicalQuantitySchedule = _physicalQuantitySchedule == null ? null : _physicalQuantitySchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("totalPhysicalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("totalPhysicalQuantity")
		@Override
		public MetalPhysicalLeg.MetalPhysicalLegBuilder setTotalPhysicalQuantity(UnitQuantity _totalPhysicalQuantity) {
			this.totalPhysicalQuantity = _totalPhysicalQuantity == null ? null : _totalPhysicalQuantity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("conversionFactor")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("conversionFactor")
		@Override
		public MetalPhysicalLeg.MetalPhysicalLegBuilder setConversionFactor(BigDecimal _conversionFactor) {
			this.conversionFactor = _conversionFactor == null ? null : _conversionFactor;
			return this;
		}
		
		@Override
		public MetalPhysicalLeg build() {
			return new MetalPhysicalLeg.MetalPhysicalLegImpl(this);
		}
		
		@Override
		public MetalPhysicalLeg.MetalPhysicalLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MetalPhysicalLeg.MetalPhysicalLegBuilder prune() {
			super.prune();
			if (metal!=null && !metal.prune().hasData()) metal = null;
			if (deliveryPeriods!=null && !deliveryPeriods.prune().hasData()) deliveryPeriods = null;
			if (deliveryConditions!=null && !deliveryConditions.prune().hasData()) deliveryConditions = null;
			if (physicalQuantity!=null && !physicalQuantity.prune().hasData()) physicalQuantity = null;
			if (physicalQuantitySchedule!=null && !physicalQuantitySchedule.prune().hasData()) physicalQuantitySchedule = null;
			if (totalPhysicalQuantity!=null && !totalPhysicalQuantity.prune().hasData()) totalPhysicalQuantity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getMetal()!=null && getMetal().hasData()) return true;
			if (getDeliveryPeriods()!=null && getDeliveryPeriods().hasData()) return true;
			if (getDeliveryConditions()!=null && getDeliveryConditions().hasData()) return true;
			if (getPhysicalQuantity()!=null && getPhysicalQuantity().hasData()) return true;
			if (getPhysicalQuantitySchedule()!=null && getPhysicalQuantitySchedule().hasData()) return true;
			if (getTotalPhysicalQuantity()!=null && getTotalPhysicalQuantity().hasData()) return true;
			if (getConversionFactor()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MetalPhysicalLeg.MetalPhysicalLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			MetalPhysicalLeg.MetalPhysicalLegBuilder o = (MetalPhysicalLeg.MetalPhysicalLegBuilder) other;
			
			merger.mergeRosetta(getMetal(), o.getMetal(), this::setMetal);
			merger.mergeRosetta(getDeliveryPeriods(), o.getDeliveryPeriods(), this::setDeliveryPeriods);
			merger.mergeRosetta(getDeliveryConditions(), o.getDeliveryConditions(), this::setDeliveryConditions);
			merger.mergeRosetta(getPhysicalQuantity(), o.getPhysicalQuantity(), this::setPhysicalQuantity);
			merger.mergeRosetta(getPhysicalQuantitySchedule(), o.getPhysicalQuantitySchedule(), this::setPhysicalQuantitySchedule);
			merger.mergeRosetta(getTotalPhysicalQuantity(), o.getTotalPhysicalQuantity(), this::setTotalPhysicalQuantity);
			
			merger.mergeBasic(getConversionFactor(), o.getConversionFactor(), this::setConversionFactor);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MetalPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(metal, _that.getMetal())) return false;
			if (!Objects.equals(deliveryPeriods, _that.getDeliveryPeriods())) return false;
			if (!Objects.equals(deliveryConditions, _that.getDeliveryConditions())) return false;
			if (!Objects.equals(physicalQuantity, _that.getPhysicalQuantity())) return false;
			if (!Objects.equals(physicalQuantitySchedule, _that.getPhysicalQuantitySchedule())) return false;
			if (!Objects.equals(totalPhysicalQuantity, _that.getTotalPhysicalQuantity())) return false;
			if (!Objects.equals(conversionFactor, _that.getConversionFactor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (metal != null ? metal.hashCode() : 0);
			_result = 31 * _result + (deliveryPeriods != null ? deliveryPeriods.hashCode() : 0);
			_result = 31 * _result + (deliveryConditions != null ? deliveryConditions.hashCode() : 0);
			_result = 31 * _result + (physicalQuantity != null ? physicalQuantity.hashCode() : 0);
			_result = 31 * _result + (physicalQuantitySchedule != null ? physicalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (totalPhysicalQuantity != null ? totalPhysicalQuantity.hashCode() : 0);
			_result = 31 * _result + (conversionFactor != null ? conversionFactor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MetalPhysicalLegBuilder {" +
				"metal=" + this.metal + ", " +
				"deliveryPeriods=" + this.deliveryPeriods + ", " +
				"deliveryConditions=" + this.deliveryConditions + ", " +
				"physicalQuantity=" + this.physicalQuantity + ", " +
				"physicalQuantitySchedule=" + this.physicalQuantitySchedule + ", " +
				"totalPhysicalQuantity=" + this.totalPhysicalQuantity + ", " +
				"conversionFactor=" + this.conversionFactor +
			'}' + " " + super.toString();
		}
	}
}
