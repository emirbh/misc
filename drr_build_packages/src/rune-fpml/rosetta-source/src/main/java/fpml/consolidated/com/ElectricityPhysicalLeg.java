package fpml.consolidated.com;

import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.asset.CommodityClassification;
import fpml.consolidated.com.meta.ElectricityPhysicalLegMeta;
import fpml.consolidated.fpmlenum.LoadTypeEnum;
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
 * Provision Physically settled leg of a physically settled electricity transaction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Physically settled leg of a physically settled electricity transaction.
 *
 */
@RosettaDataType(value="ElectricityPhysicalLeg", builder=ElectricityPhysicalLeg.ElectricityPhysicalLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ElectricityPhysicalLeg", model="fpml", builder=ElectricityPhysicalLeg.ElectricityPhysicalLegBuilderImpl.class, version="2.1.1")
public interface ElectricityPhysicalLeg extends PhysicalSwapLeg {

	ElectricityPhysicalLegMeta metaData = new ElectricityPhysicalLegMeta();

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
	 * Provision The specification of the Settlement Periods in which the electricity will be delivered. The Settlement Periods will apply from and including the Effective Date up to and including the Termination Date. If more than one settlementPeriods element is present this indicates multiple ranges of Settlement Periods apply to the entire trade - for example off-peak weekdays and all day weekends. Settlement Period ranges should not overlap.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The specification of the Settlement Periods in which the electricity will be delivered. The Settlement Periods will apply from and including the Effective Date up to and including the Termination Date. If more than one settlementPeriods element is present this indicates multiple ranges of Settlement Periods apply to the entire trade - for example off-peak weekdays and all day weekends. Settlement Period ranges should not overlap.
	 *
	 */
	List<? extends SettlementPeriods> getSettlementPeriods();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The specification of the Settlement Periods in which the electricity will be delivered for a "shaped" trade i.e. where different Settlement Period ranges will apply to different periods of the trade.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The specification of the Settlement Periods in which the electricity will be delivered for a "shaped" trade i.e. where different Settlement Period ranges will apply to different periods of the trade.
	 *
	 */
	SettlementPeriodsSchedule getSettlementPeriodsSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision LoadType is a summary of the full description of the settlement periods with respect to the region. Used for describing Electricity delivery schedules (e.g. Base, Peak, Off-Peak, Custom).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision LoadType is a summary of the full description of the settlement periods with respect to the region. Used for describing Electricity delivery schedules (e.g. Base, Peak, Off-Peak, Custom).
	 *
	 */
	LoadTypeEnum getLoadType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The specification of the electricity to be delivered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The specification of the electricity to be delivered.
	 *
	 */
	ElectricityProduct getElectricity();
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
	ElectricityDelivery getDeliveryConditions();
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
	ElectricityPhysicalQuantity getDeliveryQuantity();

	/*********************** Build Methods  ***********************/
	ElectricityPhysicalLeg build();
	
	ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder toBuilder();
	
	static ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder builder() {
		return new ElectricityPhysicalLeg.ElectricityPhysicalLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectricityPhysicalLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ElectricityPhysicalLeg> getType() {
		return ElectricityPhysicalLeg.class;
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
		processRosetta(path.newSubPath("settlementPeriods"), processor, SettlementPeriods.class, getSettlementPeriods());
		processRosetta(path.newSubPath("settlementPeriodsSchedule"), processor, SettlementPeriodsSchedule.class, getSettlementPeriodsSchedule());
		processor.processBasic(path.newSubPath("loadType"), LoadTypeEnum.class, getLoadType(), this);
		processRosetta(path.newSubPath("electricity"), processor, ElectricityProduct.class, getElectricity());
		processRosetta(path.newSubPath("deliveryConditions"), processor, ElectricityDelivery.class, getDeliveryConditions());
		processRosetta(path.newSubPath("deliveryQuantity"), processor, ElectricityPhysicalQuantity.class, getDeliveryQuantity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectricityPhysicalLegBuilder extends ElectricityPhysicalLeg, PhysicalSwapLeg.PhysicalSwapLegBuilder {
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder getOrCreateDeliveryPeriods();
		@Override
		CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder getDeliveryPeriods();
		SettlementPeriods.SettlementPeriodsBuilder getOrCreateSettlementPeriods(int index);
		@Override
		List<? extends SettlementPeriods.SettlementPeriodsBuilder> getSettlementPeriods();
		SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder getOrCreateSettlementPeriodsSchedule();
		@Override
		SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder getSettlementPeriodsSchedule();
		ElectricityProduct.ElectricityProductBuilder getOrCreateElectricity();
		@Override
		ElectricityProduct.ElectricityProductBuilder getElectricity();
		ElectricityDelivery.ElectricityDeliveryBuilder getOrCreateDeliveryConditions();
		@Override
		ElectricityDelivery.ElectricityDeliveryBuilder getDeliveryConditions();
		ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder getOrCreateDeliveryQuantity();
		@Override
		ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder getDeliveryQuantity();
		@Override
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setId(String id);
		@Override
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder addCommodityClassification(CommodityClassification commodityClassification);
		@Override
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder addCommodityClassification(CommodityClassification commodityClassification, int idx);
		@Override
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder addCommodityClassification(List<? extends CommodityClassification> commodityClassification);
		@Override
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setCommodityClassification(List<? extends CommodityClassification> commodityClassification);
		@Override
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setDeliveryPeriods(CommodityDeliveryPeriods deliveryPeriods);
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder addSettlementPeriods(SettlementPeriods settlementPeriods);
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder addSettlementPeriods(SettlementPeriods settlementPeriods, int idx);
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder addSettlementPeriods(List<? extends SettlementPeriods> settlementPeriods);
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setSettlementPeriods(List<? extends SettlementPeriods> settlementPeriods);
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setSettlementPeriodsSchedule(SettlementPeriodsSchedule settlementPeriodsSchedule);
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setLoadType(LoadTypeEnum loadType);
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setElectricity(ElectricityProduct electricity);
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setDeliveryConditions(ElectricityDelivery deliveryConditions);
		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setDeliveryQuantity(ElectricityPhysicalQuantity deliveryQuantity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("commodityClassification"), processor, CommodityClassification.CommodityClassificationBuilder.class, getCommodityClassification());
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("deliveryPeriods"), processor, CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder.class, getDeliveryPeriods());
			processRosetta(path.newSubPath("settlementPeriods"), processor, SettlementPeriods.SettlementPeriodsBuilder.class, getSettlementPeriods());
			processRosetta(path.newSubPath("settlementPeriodsSchedule"), processor, SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder.class, getSettlementPeriodsSchedule());
			processor.processBasic(path.newSubPath("loadType"), LoadTypeEnum.class, getLoadType(), this);
			processRosetta(path.newSubPath("electricity"), processor, ElectricityProduct.ElectricityProductBuilder.class, getElectricity());
			processRosetta(path.newSubPath("deliveryConditions"), processor, ElectricityDelivery.ElectricityDeliveryBuilder.class, getDeliveryConditions());
			processRosetta(path.newSubPath("deliveryQuantity"), processor, ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder.class, getDeliveryQuantity());
		}
		

		ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder prune();
	}

	/*********************** Immutable Implementation of ElectricityPhysicalLeg  ***********************/
	class ElectricityPhysicalLegImpl extends PhysicalSwapLeg.PhysicalSwapLegImpl implements ElectricityPhysicalLeg {
		private final CommodityDeliveryPeriods deliveryPeriods;
		private final List<? extends SettlementPeriods> settlementPeriods;
		private final SettlementPeriodsSchedule settlementPeriodsSchedule;
		private final LoadTypeEnum loadType;
		private final ElectricityProduct electricity;
		private final ElectricityDelivery deliveryConditions;
		private final ElectricityPhysicalQuantity deliveryQuantity;
		
		protected ElectricityPhysicalLegImpl(ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder builder) {
			super(builder);
			this.deliveryPeriods = ofNullable(builder.getDeliveryPeriods()).map(f->f.build()).orElse(null);
			this.settlementPeriods = ofNullable(builder.getSettlementPeriods()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.settlementPeriodsSchedule = ofNullable(builder.getSettlementPeriodsSchedule()).map(f->f.build()).orElse(null);
			this.loadType = builder.getLoadType();
			this.electricity = ofNullable(builder.getElectricity()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("settlementPeriods")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("settlementPeriods")
		public List<? extends SettlementPeriods> getSettlementPeriods() {
			return settlementPeriods;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementPeriodsSchedule")
		public SettlementPeriodsSchedule getSettlementPeriodsSchedule() {
			return settlementPeriodsSchedule;
		}
		
		@Override
		@RosettaAttribute("loadType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loadType")
		public LoadTypeEnum getLoadType() {
			return loadType;
		}
		
		@Override
		@RosettaAttribute("electricity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("electricity")
		public ElectricityProduct getElectricity() {
			return electricity;
		}
		
		@Override
		@RosettaAttribute("deliveryConditions")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("deliveryConditions")
		public ElectricityDelivery getDeliveryConditions() {
			return deliveryConditions;
		}
		
		@Override
		@RosettaAttribute("deliveryQuantity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("deliveryQuantity")
		public ElectricityPhysicalQuantity getDeliveryQuantity() {
			return deliveryQuantity;
		}
		
		@Override
		public ElectricityPhysicalLeg build() {
			return this;
		}
		
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder toBuilder() {
			ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDeliveryPeriods()).ifPresent(builder::setDeliveryPeriods);
			ofNullable(getSettlementPeriods()).ifPresent(builder::setSettlementPeriods);
			ofNullable(getSettlementPeriodsSchedule()).ifPresent(builder::setSettlementPeriodsSchedule);
			ofNullable(getLoadType()).ifPresent(builder::setLoadType);
			ofNullable(getElectricity()).ifPresent(builder::setElectricity);
			ofNullable(getDeliveryConditions()).ifPresent(builder::setDeliveryConditions);
			ofNullable(getDeliveryQuantity()).ifPresent(builder::setDeliveryQuantity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ElectricityPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPeriods, _that.getDeliveryPeriods())) return false;
			if (!ListEquals.listEquals(settlementPeriods, _that.getSettlementPeriods())) return false;
			if (!Objects.equals(settlementPeriodsSchedule, _that.getSettlementPeriodsSchedule())) return false;
			if (!Objects.equals(loadType, _that.getLoadType())) return false;
			if (!Objects.equals(electricity, _that.getElectricity())) return false;
			if (!Objects.equals(deliveryConditions, _that.getDeliveryConditions())) return false;
			if (!Objects.equals(deliveryQuantity, _that.getDeliveryQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deliveryPeriods != null ? deliveryPeriods.hashCode() : 0);
			_result = 31 * _result + (settlementPeriods != null ? settlementPeriods.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsSchedule != null ? settlementPeriodsSchedule.hashCode() : 0);
			_result = 31 * _result + (loadType != null ? loadType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (electricity != null ? electricity.hashCode() : 0);
			_result = 31 * _result + (deliveryConditions != null ? deliveryConditions.hashCode() : 0);
			_result = 31 * _result + (deliveryQuantity != null ? deliveryQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityPhysicalLeg {" +
				"deliveryPeriods=" + this.deliveryPeriods + ", " +
				"settlementPeriods=" + this.settlementPeriods + ", " +
				"settlementPeriodsSchedule=" + this.settlementPeriodsSchedule + ", " +
				"loadType=" + this.loadType + ", " +
				"electricity=" + this.electricity + ", " +
				"deliveryConditions=" + this.deliveryConditions + ", " +
				"deliveryQuantity=" + this.deliveryQuantity +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ElectricityPhysicalLeg  ***********************/
	class ElectricityPhysicalLegBuilderImpl extends PhysicalSwapLeg.PhysicalSwapLegBuilderImpl implements ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder {
	
		protected CommodityDeliveryPeriods.CommodityDeliveryPeriodsBuilder deliveryPeriods;
		protected List<SettlementPeriods.SettlementPeriodsBuilder> settlementPeriods = new ArrayList<>();
		protected SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder settlementPeriodsSchedule;
		protected LoadTypeEnum loadType;
		protected ElectricityProduct.ElectricityProductBuilder electricity;
		protected ElectricityDelivery.ElectricityDeliveryBuilder deliveryConditions;
		protected ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder deliveryQuantity;
		
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
		@RosettaAttribute("settlementPeriods")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("settlementPeriods")
		public List<? extends SettlementPeriods.SettlementPeriodsBuilder> getSettlementPeriods() {
			return settlementPeriods;
		}
		
		@Override
		public SettlementPeriods.SettlementPeriodsBuilder getOrCreateSettlementPeriods(int index) {
			if (settlementPeriods==null) {
				this.settlementPeriods = new ArrayList<>();
			}
			return getIndex(settlementPeriods, index, () -> {
						SettlementPeriods.SettlementPeriodsBuilder newSettlementPeriods = SettlementPeriods.builder();
						return newSettlementPeriods;
					});
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementPeriodsSchedule")
		public SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder getSettlementPeriodsSchedule() {
			return settlementPeriodsSchedule;
		}
		
		@Override
		public SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder getOrCreateSettlementPeriodsSchedule() {
			SettlementPeriodsSchedule.SettlementPeriodsScheduleBuilder result;
			if (settlementPeriodsSchedule!=null) {
				result = settlementPeriodsSchedule;
			}
			else {
				result = settlementPeriodsSchedule = SettlementPeriodsSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("loadType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loadType")
		public LoadTypeEnum getLoadType() {
			return loadType;
		}
		
		@Override
		@RosettaAttribute("electricity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("electricity")
		public ElectricityProduct.ElectricityProductBuilder getElectricity() {
			return electricity;
		}
		
		@Override
		public ElectricityProduct.ElectricityProductBuilder getOrCreateElectricity() {
			ElectricityProduct.ElectricityProductBuilder result;
			if (electricity!=null) {
				result = electricity;
			}
			else {
				result = electricity = ElectricityProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryConditions")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("deliveryConditions")
		public ElectricityDelivery.ElectricityDeliveryBuilder getDeliveryConditions() {
			return deliveryConditions;
		}
		
		@Override
		public ElectricityDelivery.ElectricityDeliveryBuilder getOrCreateDeliveryConditions() {
			ElectricityDelivery.ElectricityDeliveryBuilder result;
			if (deliveryConditions!=null) {
				result = deliveryConditions;
			}
			else {
				result = deliveryConditions = ElectricityDelivery.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deliveryQuantity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("deliveryQuantity")
		public ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder getDeliveryQuantity() {
			return deliveryQuantity;
		}
		
		@Override
		public ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder getOrCreateDeliveryQuantity() {
			ElectricityPhysicalQuantity.ElectricityPhysicalQuantityBuilder result;
			if (deliveryQuantity!=null) {
				result = deliveryQuantity;
			}
			else {
				result = deliveryQuantity = ElectricityPhysicalQuantity.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("commodityClassification")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("commodityClassification")
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder addCommodityClassification(CommodityClassification _commodityClassification) {
			if (_commodityClassification != null) {
				this.commodityClassification.add(_commodityClassification.toBuilder());
			}
			return this;
		}
		
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder addCommodityClassification(CommodityClassification _commodityClassification, int idx) {
			getIndex(this.commodityClassification, idx, () -> _commodityClassification.toBuilder());
			return this;
		}
		
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder addCommodityClassification(List<? extends CommodityClassification> commodityClassifications) {
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
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setCommodityClassification(List<? extends CommodityClassification> commodityClassifications) {
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
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryPeriods")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryPeriods")
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setDeliveryPeriods(CommodityDeliveryPeriods _deliveryPeriods) {
			this.deliveryPeriods = _deliveryPeriods == null ? null : _deliveryPeriods.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementPeriods")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("settlementPeriods")
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder addSettlementPeriods(SettlementPeriods _settlementPeriods) {
			if (_settlementPeriods != null) {
				this.settlementPeriods.add(_settlementPeriods.toBuilder());
			}
			return this;
		}
		
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder addSettlementPeriods(SettlementPeriods _settlementPeriods, int idx) {
			getIndex(this.settlementPeriods, idx, () -> _settlementPeriods.toBuilder());
			return this;
		}
		
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder addSettlementPeriods(List<? extends SettlementPeriods> settlementPeriodss) {
			if (settlementPeriodss != null) {
				for (final SettlementPeriods toAdd : settlementPeriodss) {
					this.settlementPeriods.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriods")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("settlementPeriods")
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setSettlementPeriods(List<? extends SettlementPeriods> settlementPeriodss) {
			if (settlementPeriodss == null) {
				this.settlementPeriods = new ArrayList<>();
			} else {
				this.settlementPeriods = settlementPeriodss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementPeriodsSchedule")
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setSettlementPeriodsSchedule(SettlementPeriodsSchedule _settlementPeriodsSchedule) {
			this.settlementPeriodsSchedule = _settlementPeriodsSchedule == null ? null : _settlementPeriodsSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("loadType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("loadType")
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setLoadType(LoadTypeEnum _loadType) {
			this.loadType = _loadType == null ? null : _loadType;
			return this;
		}
		
		@RosettaAttribute("electricity")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("electricity")
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setElectricity(ElectricityProduct _electricity) {
			this.electricity = _electricity == null ? null : _electricity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryConditions")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("deliveryConditions")
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setDeliveryConditions(ElectricityDelivery _deliveryConditions) {
			this.deliveryConditions = _deliveryConditions == null ? null : _deliveryConditions.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deliveryQuantity")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("deliveryQuantity")
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder setDeliveryQuantity(ElectricityPhysicalQuantity _deliveryQuantity) {
			this.deliveryQuantity = _deliveryQuantity == null ? null : _deliveryQuantity.toBuilder();
			return this;
		}
		
		@Override
		public ElectricityPhysicalLeg build() {
			return new ElectricityPhysicalLeg.ElectricityPhysicalLegImpl(this);
		}
		
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder prune() {
			super.prune();
			if (deliveryPeriods!=null && !deliveryPeriods.prune().hasData()) deliveryPeriods = null;
			settlementPeriods = settlementPeriods.stream().filter(b->b!=null).<SettlementPeriods.SettlementPeriodsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (settlementPeriodsSchedule!=null && !settlementPeriodsSchedule.prune().hasData()) settlementPeriodsSchedule = null;
			if (electricity!=null && !electricity.prune().hasData()) electricity = null;
			if (deliveryConditions!=null && !deliveryConditions.prune().hasData()) deliveryConditions = null;
			if (deliveryQuantity!=null && !deliveryQuantity.prune().hasData()) deliveryQuantity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDeliveryPeriods()!=null && getDeliveryPeriods().hasData()) return true;
			if (getSettlementPeriods()!=null && getSettlementPeriods().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSettlementPeriodsSchedule()!=null && getSettlementPeriodsSchedule().hasData()) return true;
			if (getLoadType()!=null) return true;
			if (getElectricity()!=null && getElectricity().hasData()) return true;
			if (getDeliveryConditions()!=null && getDeliveryConditions().hasData()) return true;
			if (getDeliveryQuantity()!=null && getDeliveryQuantity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder o = (ElectricityPhysicalLeg.ElectricityPhysicalLegBuilder) other;
			
			merger.mergeRosetta(getDeliveryPeriods(), o.getDeliveryPeriods(), this::setDeliveryPeriods);
			merger.mergeRosetta(getSettlementPeriods(), o.getSettlementPeriods(), this::getOrCreateSettlementPeriods);
			merger.mergeRosetta(getSettlementPeriodsSchedule(), o.getSettlementPeriodsSchedule(), this::setSettlementPeriodsSchedule);
			merger.mergeRosetta(getElectricity(), o.getElectricity(), this::setElectricity);
			merger.mergeRosetta(getDeliveryConditions(), o.getDeliveryConditions(), this::setDeliveryConditions);
			merger.mergeRosetta(getDeliveryQuantity(), o.getDeliveryQuantity(), this::setDeliveryQuantity);
			
			merger.mergeBasic(getLoadType(), o.getLoadType(), this::setLoadType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ElectricityPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(deliveryPeriods, _that.getDeliveryPeriods())) return false;
			if (!ListEquals.listEquals(settlementPeriods, _that.getSettlementPeriods())) return false;
			if (!Objects.equals(settlementPeriodsSchedule, _that.getSettlementPeriodsSchedule())) return false;
			if (!Objects.equals(loadType, _that.getLoadType())) return false;
			if (!Objects.equals(electricity, _that.getElectricity())) return false;
			if (!Objects.equals(deliveryConditions, _that.getDeliveryConditions())) return false;
			if (!Objects.equals(deliveryQuantity, _that.getDeliveryQuantity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (deliveryPeriods != null ? deliveryPeriods.hashCode() : 0);
			_result = 31 * _result + (settlementPeriods != null ? settlementPeriods.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsSchedule != null ? settlementPeriodsSchedule.hashCode() : 0);
			_result = 31 * _result + (loadType != null ? loadType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (electricity != null ? electricity.hashCode() : 0);
			_result = 31 * _result + (deliveryConditions != null ? deliveryConditions.hashCode() : 0);
			_result = 31 * _result + (deliveryQuantity != null ? deliveryQuantity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityPhysicalLegBuilder {" +
				"deliveryPeriods=" + this.deliveryPeriods + ", " +
				"settlementPeriods=" + this.settlementPeriods + ", " +
				"settlementPeriodsSchedule=" + this.settlementPeriodsSchedule + ", " +
				"loadType=" + this.loadType + ", " +
				"electricity=" + this.electricity + ", " +
				"deliveryConditions=" + this.deliveryConditions + ", " +
				"deliveryQuantity=" + this.deliveryQuantity +
			'}' + " " + super.toString();
		}
	}
}
