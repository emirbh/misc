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
import fpml.consolidated.com.meta.BullionPhysicalLegMeta;
import fpml.consolidated.fpmlenum.BullionTypeEnum;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
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
 * Provision Physically settled leg of a physically settled Bullion Transaction.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Physically settled leg of a physically settled Bullion Transaction.
 *
 */
@RosettaDataType(value="BullionPhysicalLeg", builder=BullionPhysicalLeg.BullionPhysicalLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="BullionPhysicalLeg", model="fpml", builder=BullionPhysicalLeg.BullionPhysicalLegBuilderImpl.class, version="2.1.1")
public interface BullionPhysicalLeg extends PhysicalForwardLeg {

	BullionPhysicalLegMeta metaData = new BullionPhysicalLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of Bullion underlying a Bullion Transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of Bullion underlying a Bullion Transaction.
	 *
	 */
	BullionTypeEnum getBullionType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The physical delivery location for the transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The physical delivery location for the transaction.
	 *
	 */
	BullionDeliveryLocation getDeliveryLocation();
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
	 * Provision Date on which the bullion will settle.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date on which the bullion will settle.
	 *
	 */
	AdjustableOrRelativeDate getSettlementDate();

	/*********************** Build Methods  ***********************/
	BullionPhysicalLeg build();
	
	BullionPhysicalLeg.BullionPhysicalLegBuilder toBuilder();
	
	static BullionPhysicalLeg.BullionPhysicalLegBuilder builder() {
		return new BullionPhysicalLeg.BullionPhysicalLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BullionPhysicalLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BullionPhysicalLeg> getType() {
		return BullionPhysicalLeg.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("commodityClassification"), processor, CommodityClassification.class, getCommodityClassification());
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processor.processBasic(path.newSubPath("bullionType"), BullionTypeEnum.class, getBullionType(), this);
		processRosetta(path.newSubPath("deliveryLocation"), processor, BullionDeliveryLocation.class, getDeliveryLocation());
		processRosetta(path.newSubPath("physicalQuantity"), processor, CommodityNotionalQuantity.class, getPhysicalQuantity());
		processRosetta(path.newSubPath("physicalQuantitySchedule"), processor, CommodityPhysicalQuantitySchedule.class, getPhysicalQuantitySchedule());
		processRosetta(path.newSubPath("totalPhysicalQuantity"), processor, UnitQuantity.class, getTotalPhysicalQuantity());
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.class, getSettlementDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BullionPhysicalLegBuilder extends BullionPhysicalLeg, PhysicalForwardLeg.PhysicalForwardLegBuilder {
		BullionDeliveryLocation.BullionDeliveryLocationBuilder getOrCreateDeliveryLocation();
		@Override
		BullionDeliveryLocation.BullionDeliveryLocationBuilder getDeliveryLocation();
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreatePhysicalQuantity();
		@Override
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getPhysicalQuantity();
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder getOrCreatePhysicalQuantitySchedule();
		@Override
		CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder getPhysicalQuantitySchedule();
		UnitQuantity.UnitQuantityBuilder getOrCreateTotalPhysicalQuantity();
		@Override
		UnitQuantity.UnitQuantityBuilder getTotalPhysicalQuantity();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateSettlementDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getSettlementDate();
		@Override
		BullionPhysicalLeg.BullionPhysicalLegBuilder setId(String id);
		@Override
		BullionPhysicalLeg.BullionPhysicalLegBuilder addCommodityClassification(CommodityClassification commodityClassification);
		@Override
		BullionPhysicalLeg.BullionPhysicalLegBuilder addCommodityClassification(CommodityClassification commodityClassification, int idx);
		@Override
		BullionPhysicalLeg.BullionPhysicalLegBuilder addCommodityClassification(List<? extends CommodityClassification> commodityClassification);
		@Override
		BullionPhysicalLeg.BullionPhysicalLegBuilder setCommodityClassification(List<? extends CommodityClassification> commodityClassification);
		@Override
		BullionPhysicalLeg.BullionPhysicalLegBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		BullionPhysicalLeg.BullionPhysicalLegBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		BullionPhysicalLeg.BullionPhysicalLegBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		BullionPhysicalLeg.BullionPhysicalLegBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		BullionPhysicalLeg.BullionPhysicalLegBuilder setBullionType(BullionTypeEnum bullionType);
		BullionPhysicalLeg.BullionPhysicalLegBuilder setDeliveryLocation(BullionDeliveryLocation deliveryLocation);
		BullionPhysicalLeg.BullionPhysicalLegBuilder setPhysicalQuantity(CommodityNotionalQuantity physicalQuantity);
		BullionPhysicalLeg.BullionPhysicalLegBuilder setPhysicalQuantitySchedule(CommodityPhysicalQuantitySchedule physicalQuantitySchedule);
		BullionPhysicalLeg.BullionPhysicalLegBuilder setTotalPhysicalQuantity(UnitQuantity totalPhysicalQuantity);
		BullionPhysicalLeg.BullionPhysicalLegBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("commodityClassification"), processor, CommodityClassification.CommodityClassificationBuilder.class, getCommodityClassification());
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processor.processBasic(path.newSubPath("bullionType"), BullionTypeEnum.class, getBullionType(), this);
			processRosetta(path.newSubPath("deliveryLocation"), processor, BullionDeliveryLocation.BullionDeliveryLocationBuilder.class, getDeliveryLocation());
			processRosetta(path.newSubPath("physicalQuantity"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getPhysicalQuantity());
			processRosetta(path.newSubPath("physicalQuantitySchedule"), processor, CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder.class, getPhysicalQuantitySchedule());
			processRosetta(path.newSubPath("totalPhysicalQuantity"), processor, UnitQuantity.UnitQuantityBuilder.class, getTotalPhysicalQuantity());
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getSettlementDate());
		}
		

		BullionPhysicalLeg.BullionPhysicalLegBuilder prune();
	}

	/*********************** Immutable Implementation of BullionPhysicalLeg  ***********************/
	class BullionPhysicalLegImpl extends PhysicalForwardLeg.PhysicalForwardLegImpl implements BullionPhysicalLeg {
		private final BullionTypeEnum bullionType;
		private final BullionDeliveryLocation deliveryLocation;
		private final CommodityNotionalQuantity physicalQuantity;
		private final CommodityPhysicalQuantitySchedule physicalQuantitySchedule;
		private final UnitQuantity totalPhysicalQuantity;
		private final AdjustableOrRelativeDate settlementDate;
		
		protected BullionPhysicalLegImpl(BullionPhysicalLeg.BullionPhysicalLegBuilder builder) {
			super(builder);
			this.bullionType = builder.getBullionType();
			this.deliveryLocation = ofNullable(builder.getDeliveryLocation()).map(f->f.build()).orElse(null);
			this.physicalQuantity = ofNullable(builder.getPhysicalQuantity()).map(f->f.build()).orElse(null);
			this.physicalQuantitySchedule = ofNullable(builder.getPhysicalQuantitySchedule()).map(f->f.build()).orElse(null);
			this.totalPhysicalQuantity = ofNullable(builder.getTotalPhysicalQuantity()).map(f->f.build()).orElse(null);
			this.settlementDate = ofNullable(builder.getSettlementDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("bullionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bullionType")
		public BullionTypeEnum getBullionType() {
			return bullionType;
		}
		
		@Override
		@RosettaAttribute("deliveryLocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryLocation")
		public BullionDeliveryLocation getDeliveryLocation() {
			return deliveryLocation;
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
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDate")
		public AdjustableOrRelativeDate getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public BullionPhysicalLeg build() {
			return this;
		}
		
		@Override
		public BullionPhysicalLeg.BullionPhysicalLegBuilder toBuilder() {
			BullionPhysicalLeg.BullionPhysicalLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BullionPhysicalLeg.BullionPhysicalLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBullionType()).ifPresent(builder::setBullionType);
			ofNullable(getDeliveryLocation()).ifPresent(builder::setDeliveryLocation);
			ofNullable(getPhysicalQuantity()).ifPresent(builder::setPhysicalQuantity);
			ofNullable(getPhysicalQuantitySchedule()).ifPresent(builder::setPhysicalQuantitySchedule);
			ofNullable(getTotalPhysicalQuantity()).ifPresent(builder::setTotalPhysicalQuantity);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BullionPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(bullionType, _that.getBullionType())) return false;
			if (!Objects.equals(deliveryLocation, _that.getDeliveryLocation())) return false;
			if (!Objects.equals(physicalQuantity, _that.getPhysicalQuantity())) return false;
			if (!Objects.equals(physicalQuantitySchedule, _that.getPhysicalQuantitySchedule())) return false;
			if (!Objects.equals(totalPhysicalQuantity, _that.getTotalPhysicalQuantity())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (bullionType != null ? bullionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryLocation != null ? deliveryLocation.hashCode() : 0);
			_result = 31 * _result + (physicalQuantity != null ? physicalQuantity.hashCode() : 0);
			_result = 31 * _result + (physicalQuantitySchedule != null ? physicalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (totalPhysicalQuantity != null ? totalPhysicalQuantity.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BullionPhysicalLeg {" +
				"bullionType=" + this.bullionType + ", " +
				"deliveryLocation=" + this.deliveryLocation + ", " +
				"physicalQuantity=" + this.physicalQuantity + ", " +
				"physicalQuantitySchedule=" + this.physicalQuantitySchedule + ", " +
				"totalPhysicalQuantity=" + this.totalPhysicalQuantity + ", " +
				"settlementDate=" + this.settlementDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BullionPhysicalLeg  ***********************/
	class BullionPhysicalLegBuilderImpl extends PhysicalForwardLeg.PhysicalForwardLegBuilderImpl implements BullionPhysicalLeg.BullionPhysicalLegBuilder {
	
		protected BullionTypeEnum bullionType;
		protected BullionDeliveryLocation.BullionDeliveryLocationBuilder deliveryLocation;
		protected CommodityNotionalQuantity.CommodityNotionalQuantityBuilder physicalQuantity;
		protected CommodityPhysicalQuantitySchedule.CommodityPhysicalQuantityScheduleBuilder physicalQuantitySchedule;
		protected UnitQuantity.UnitQuantityBuilder totalPhysicalQuantity;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder settlementDate;
		
		@Override
		@RosettaAttribute("bullionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bullionType")
		public BullionTypeEnum getBullionType() {
			return bullionType;
		}
		
		@Override
		@RosettaAttribute("deliveryLocation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deliveryLocation")
		public BullionDeliveryLocation.BullionDeliveryLocationBuilder getDeliveryLocation() {
			return deliveryLocation;
		}
		
		@Override
		public BullionDeliveryLocation.BullionDeliveryLocationBuilder getOrCreateDeliveryLocation() {
			BullionDeliveryLocation.BullionDeliveryLocationBuilder result;
			if (deliveryLocation!=null) {
				result = deliveryLocation;
			}
			else {
				result = deliveryLocation = BullionDeliveryLocation.builder();
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
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateSettlementDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (settlementDate!=null) {
				result = settlementDate;
			}
			else {
				result = settlementDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public BullionPhysicalLeg.BullionPhysicalLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("commodityClassification")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("commodityClassification")
		@Override
		public BullionPhysicalLeg.BullionPhysicalLegBuilder addCommodityClassification(CommodityClassification _commodityClassification) {
			if (_commodityClassification != null) {
				this.commodityClassification.add(_commodityClassification.toBuilder());
			}
			return this;
		}
		
		@Override
		public BullionPhysicalLeg.BullionPhysicalLegBuilder addCommodityClassification(CommodityClassification _commodityClassification, int idx) {
			getIndex(this.commodityClassification, idx, () -> _commodityClassification.toBuilder());
			return this;
		}
		
		@Override
		public BullionPhysicalLeg.BullionPhysicalLegBuilder addCommodityClassification(List<? extends CommodityClassification> commodityClassifications) {
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
		public BullionPhysicalLeg.BullionPhysicalLegBuilder setCommodityClassification(List<? extends CommodityClassification> commodityClassifications) {
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
		public BullionPhysicalLeg.BullionPhysicalLegBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public BullionPhysicalLeg.BullionPhysicalLegBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public BullionPhysicalLeg.BullionPhysicalLegBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public BullionPhysicalLeg.BullionPhysicalLegBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("bullionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bullionType")
		@Override
		public BullionPhysicalLeg.BullionPhysicalLegBuilder setBullionType(BullionTypeEnum _bullionType) {
			this.bullionType = _bullionType == null ? null : _bullionType;
			return this;
		}
		
		@RosettaAttribute("deliveryLocation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deliveryLocation")
		@Override
		public BullionPhysicalLeg.BullionPhysicalLegBuilder setDeliveryLocation(BullionDeliveryLocation _deliveryLocation) {
			this.deliveryLocation = _deliveryLocation == null ? null : _deliveryLocation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("physicalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("physicalQuantity")
		@Override
		public BullionPhysicalLeg.BullionPhysicalLegBuilder setPhysicalQuantity(CommodityNotionalQuantity _physicalQuantity) {
			this.physicalQuantity = _physicalQuantity == null ? null : _physicalQuantity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("physicalQuantitySchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("physicalQuantitySchedule")
		@Override
		public BullionPhysicalLeg.BullionPhysicalLegBuilder setPhysicalQuantitySchedule(CommodityPhysicalQuantitySchedule _physicalQuantitySchedule) {
			this.physicalQuantitySchedule = _physicalQuantitySchedule == null ? null : _physicalQuantitySchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("totalPhysicalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("totalPhysicalQuantity")
		@Override
		public BullionPhysicalLeg.BullionPhysicalLegBuilder setTotalPhysicalQuantity(UnitQuantity _totalPhysicalQuantity) {
			this.totalPhysicalQuantity = _totalPhysicalQuantity == null ? null : _totalPhysicalQuantity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDate")
		@Override
		public BullionPhysicalLeg.BullionPhysicalLegBuilder setSettlementDate(AdjustableOrRelativeDate _settlementDate) {
			this.settlementDate = _settlementDate == null ? null : _settlementDate.toBuilder();
			return this;
		}
		
		@Override
		public BullionPhysicalLeg build() {
			return new BullionPhysicalLeg.BullionPhysicalLegImpl(this);
		}
		
		@Override
		public BullionPhysicalLeg.BullionPhysicalLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BullionPhysicalLeg.BullionPhysicalLegBuilder prune() {
			super.prune();
			if (deliveryLocation!=null && !deliveryLocation.prune().hasData()) deliveryLocation = null;
			if (physicalQuantity!=null && !physicalQuantity.prune().hasData()) physicalQuantity = null;
			if (physicalQuantitySchedule!=null && !physicalQuantitySchedule.prune().hasData()) physicalQuantitySchedule = null;
			if (totalPhysicalQuantity!=null && !totalPhysicalQuantity.prune().hasData()) totalPhysicalQuantity = null;
			if (settlementDate!=null && !settlementDate.prune().hasData()) settlementDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBullionType()!=null) return true;
			if (getDeliveryLocation()!=null && getDeliveryLocation().hasData()) return true;
			if (getPhysicalQuantity()!=null && getPhysicalQuantity().hasData()) return true;
			if (getPhysicalQuantitySchedule()!=null && getPhysicalQuantitySchedule().hasData()) return true;
			if (getTotalPhysicalQuantity()!=null && getTotalPhysicalQuantity().hasData()) return true;
			if (getSettlementDate()!=null && getSettlementDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BullionPhysicalLeg.BullionPhysicalLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			BullionPhysicalLeg.BullionPhysicalLegBuilder o = (BullionPhysicalLeg.BullionPhysicalLegBuilder) other;
			
			merger.mergeRosetta(getDeliveryLocation(), o.getDeliveryLocation(), this::setDeliveryLocation);
			merger.mergeRosetta(getPhysicalQuantity(), o.getPhysicalQuantity(), this::setPhysicalQuantity);
			merger.mergeRosetta(getPhysicalQuantitySchedule(), o.getPhysicalQuantitySchedule(), this::setPhysicalQuantitySchedule);
			merger.mergeRosetta(getTotalPhysicalQuantity(), o.getTotalPhysicalQuantity(), this::setTotalPhysicalQuantity);
			merger.mergeRosetta(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			
			merger.mergeBasic(getBullionType(), o.getBullionType(), this::setBullionType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BullionPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(bullionType, _that.getBullionType())) return false;
			if (!Objects.equals(deliveryLocation, _that.getDeliveryLocation())) return false;
			if (!Objects.equals(physicalQuantity, _that.getPhysicalQuantity())) return false;
			if (!Objects.equals(physicalQuantitySchedule, _that.getPhysicalQuantitySchedule())) return false;
			if (!Objects.equals(totalPhysicalQuantity, _that.getTotalPhysicalQuantity())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (bullionType != null ? bullionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryLocation != null ? deliveryLocation.hashCode() : 0);
			_result = 31 * _result + (physicalQuantity != null ? physicalQuantity.hashCode() : 0);
			_result = 31 * _result + (physicalQuantitySchedule != null ? physicalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (totalPhysicalQuantity != null ? totalPhysicalQuantity.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BullionPhysicalLegBuilder {" +
				"bullionType=" + this.bullionType + ", " +
				"deliveryLocation=" + this.deliveryLocation + ", " +
				"physicalQuantity=" + this.physicalQuantity + ", " +
				"physicalQuantitySchedule=" + this.physicalQuantitySchedule + ", " +
				"totalPhysicalQuantity=" + this.totalPhysicalQuantity + ", " +
				"settlementDate=" + this.settlementDate +
			'}' + " " + super.toString();
		}
	}
}
