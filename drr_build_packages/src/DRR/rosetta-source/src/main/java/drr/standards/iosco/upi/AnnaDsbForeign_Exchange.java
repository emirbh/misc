package drr.standards.iosco.upi;

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
import drr.standards.iosco.upi.meta.AnnaDsbForeign_ExchangeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbForeign_Exchange", builder=AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbForeign_Exchange", model="drr", builder=AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilderImpl.class, version="7.7.0")
public interface AnnaDsbForeign_Exchange extends RosettaModelObject {

	AnnaDsbForeign_ExchangeMeta metaData = new AnnaDsbForeign_ExchangeMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource();
	AnnaDsbReturnorPayoutTriggerEnum getReturnorPayoutTrigger();
	AnnaDsbPlaceofSettlementEnum getPlaceofSettlement();
	AnnaDsbOtherUnderlierIDSourceEnum getOtherUnderlierIDSource();
	String getOtherUnderlierID();
	String getUnderlierID();
	String getSettlementCurrency();
	String getNotionalCurrency();
	String getOtherNotionalCurrency();
	String getUnderlierName();

	/*********************** Build Methods  ***********************/
	AnnaDsbForeign_Exchange build();
	
	AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder toBuilder();
	
	static AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder builder() {
		return new AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbForeign_Exchange> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbForeign_Exchange> getType() {
		return AnnaDsbForeign_Exchange.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("UnderlierIDSource"), AnnaDsbUnderlierIDSourceEnum.class, getUnderlierIDSource(), this);
		processor.processBasic(path.newSubPath("ReturnorPayoutTrigger"), AnnaDsbReturnorPayoutTriggerEnum.class, getReturnorPayoutTrigger(), this);
		processor.processBasic(path.newSubPath("PlaceofSettlement"), AnnaDsbPlaceofSettlementEnum.class, getPlaceofSettlement(), this);
		processor.processBasic(path.newSubPath("OtherUnderlierIDSource"), AnnaDsbOtherUnderlierIDSourceEnum.class, getOtherUnderlierIDSource(), this);
		processor.processBasic(path.newSubPath("OtherUnderlierID"), String.class, getOtherUnderlierID(), this);
		processor.processBasic(path.newSubPath("UnderlierID"), String.class, getUnderlierID(), this);
		processor.processBasic(path.newSubPath("SettlementCurrency"), String.class, getSettlementCurrency(), this);
		processor.processBasic(path.newSubPath("NotionalCurrency"), String.class, getNotionalCurrency(), this);
		processor.processBasic(path.newSubPath("OtherNotionalCurrency"), String.class, getOtherNotionalCurrency(), this);
		processor.processBasic(path.newSubPath("UnderlierName"), String.class, getUnderlierName(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbForeign_ExchangeBuilder extends AnnaDsbForeign_Exchange, RosettaModelObjectBuilder {
		AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder setUnderlierIDSource(AnnaDsbUnderlierIDSourceEnum UnderlierIDSource);
		AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder setReturnorPayoutTrigger(AnnaDsbReturnorPayoutTriggerEnum ReturnorPayoutTrigger);
		AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder setPlaceofSettlement(AnnaDsbPlaceofSettlementEnum PlaceofSettlement);
		AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder setOtherUnderlierIDSource(AnnaDsbOtherUnderlierIDSourceEnum OtherUnderlierIDSource);
		AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder setOtherUnderlierID(String OtherUnderlierID);
		AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder setUnderlierID(String UnderlierID);
		AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder setSettlementCurrency(String SettlementCurrency);
		AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder setNotionalCurrency(String NotionalCurrency);
		AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder setOtherNotionalCurrency(String OtherNotionalCurrency);
		AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder setUnderlierName(String UnderlierName);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("UnderlierIDSource"), AnnaDsbUnderlierIDSourceEnum.class, getUnderlierIDSource(), this);
			processor.processBasic(path.newSubPath("ReturnorPayoutTrigger"), AnnaDsbReturnorPayoutTriggerEnum.class, getReturnorPayoutTrigger(), this);
			processor.processBasic(path.newSubPath("PlaceofSettlement"), AnnaDsbPlaceofSettlementEnum.class, getPlaceofSettlement(), this);
			processor.processBasic(path.newSubPath("OtherUnderlierIDSource"), AnnaDsbOtherUnderlierIDSourceEnum.class, getOtherUnderlierIDSource(), this);
			processor.processBasic(path.newSubPath("OtherUnderlierID"), String.class, getOtherUnderlierID(), this);
			processor.processBasic(path.newSubPath("UnderlierID"), String.class, getUnderlierID(), this);
			processor.processBasic(path.newSubPath("SettlementCurrency"), String.class, getSettlementCurrency(), this);
			processor.processBasic(path.newSubPath("NotionalCurrency"), String.class, getNotionalCurrency(), this);
			processor.processBasic(path.newSubPath("OtherNotionalCurrency"), String.class, getOtherNotionalCurrency(), this);
			processor.processBasic(path.newSubPath("UnderlierName"), String.class, getUnderlierName(), this);
		}
		

		AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbForeign_Exchange  ***********************/
	class AnnaDsbForeign_ExchangeImpl implements AnnaDsbForeign_Exchange {
		private final AnnaDsbUnderlierIDSourceEnum underlierIDSource;
		private final AnnaDsbReturnorPayoutTriggerEnum returnorPayoutTrigger;
		private final AnnaDsbPlaceofSettlementEnum placeofSettlement;
		private final AnnaDsbOtherUnderlierIDSourceEnum otherUnderlierIDSource;
		private final String otherUnderlierID;
		private final String underlierID;
		private final String settlementCurrency;
		private final String notionalCurrency;
		private final String otherNotionalCurrency;
		private final String underlierName;
		
		protected AnnaDsbForeign_ExchangeImpl(AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder builder) {
			this.underlierIDSource = builder.getUnderlierIDSource();
			this.returnorPayoutTrigger = builder.getReturnorPayoutTrigger();
			this.placeofSettlement = builder.getPlaceofSettlement();
			this.otherUnderlierIDSource = builder.getOtherUnderlierIDSource();
			this.otherUnderlierID = builder.getOtherUnderlierID();
			this.underlierID = builder.getUnderlierID();
			this.settlementCurrency = builder.getSettlementCurrency();
			this.notionalCurrency = builder.getNotionalCurrency();
			this.otherNotionalCurrency = builder.getOtherNotionalCurrency();
			this.underlierName = builder.getUnderlierName();
		}
		
		@Override
		@RosettaAttribute("UnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierIDSource")
		public AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource() {
			return underlierIDSource;
		}
		
		@Override
		@RosettaAttribute("ReturnorPayoutTrigger")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReturnorPayoutTrigger")
		public AnnaDsbReturnorPayoutTriggerEnum getReturnorPayoutTrigger() {
			return returnorPayoutTrigger;
		}
		
		@Override
		@RosettaAttribute("PlaceofSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("PlaceofSettlement")
		public AnnaDsbPlaceofSettlementEnum getPlaceofSettlement() {
			return placeofSettlement;
		}
		
		@Override
		@RosettaAttribute("OtherUnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherUnderlierIDSource")
		public AnnaDsbOtherUnderlierIDSourceEnum getOtherUnderlierIDSource() {
			return otherUnderlierIDSource;
		}
		
		@Override
		@RosettaAttribute("OtherUnderlierID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherUnderlierID")
		public String getOtherUnderlierID() {
			return otherUnderlierID;
		}
		
		@Override
		@RosettaAttribute("UnderlierID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierID")
		public String getUnderlierID() {
			return underlierID;
		}
		
		@Override
		@RosettaAttribute("SettlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("SettlementCurrency")
		public String getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		@RosettaAttribute("NotionalCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("NotionalCurrency")
		public String getNotionalCurrency() {
			return notionalCurrency;
		}
		
		@Override
		@RosettaAttribute("OtherNotionalCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherNotionalCurrency")
		public String getOtherNotionalCurrency() {
			return otherNotionalCurrency;
		}
		
		@Override
		@RosettaAttribute("UnderlierName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierName")
		public String getUnderlierName() {
			return underlierName;
		}
		
		@Override
		public AnnaDsbForeign_Exchange build() {
			return this;
		}
		
		@Override
		public AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder toBuilder() {
			AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder builder) {
			ofNullable(getUnderlierIDSource()).ifPresent(builder::setUnderlierIDSource);
			ofNullable(getReturnorPayoutTrigger()).ifPresent(builder::setReturnorPayoutTrigger);
			ofNullable(getPlaceofSettlement()).ifPresent(builder::setPlaceofSettlement);
			ofNullable(getOtherUnderlierIDSource()).ifPresent(builder::setOtherUnderlierIDSource);
			ofNullable(getOtherUnderlierID()).ifPresent(builder::setOtherUnderlierID);
			ofNullable(getUnderlierID()).ifPresent(builder::setUnderlierID);
			ofNullable(getSettlementCurrency()).ifPresent(builder::setSettlementCurrency);
			ofNullable(getNotionalCurrency()).ifPresent(builder::setNotionalCurrency);
			ofNullable(getOtherNotionalCurrency()).ifPresent(builder::setOtherNotionalCurrency);
			ofNullable(getUnderlierName()).ifPresent(builder::setUnderlierName);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbForeign_Exchange _that = getType().cast(o);
		
			if (!Objects.equals(underlierIDSource, _that.getUnderlierIDSource())) return false;
			if (!Objects.equals(returnorPayoutTrigger, _that.getReturnorPayoutTrigger())) return false;
			if (!Objects.equals(placeofSettlement, _that.getPlaceofSettlement())) return false;
			if (!Objects.equals(otherUnderlierIDSource, _that.getOtherUnderlierIDSource())) return false;
			if (!Objects.equals(otherUnderlierID, _that.getOtherUnderlierID())) return false;
			if (!Objects.equals(underlierID, _that.getUnderlierID())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(notionalCurrency, _that.getNotionalCurrency())) return false;
			if (!Objects.equals(otherNotionalCurrency, _that.getOtherNotionalCurrency())) return false;
			if (!Objects.equals(underlierName, _that.getUnderlierName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlierIDSource != null ? underlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (returnorPayoutTrigger != null ? returnorPayoutTrigger.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (placeofSettlement != null ? placeofSettlement.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherUnderlierIDSource != null ? otherUnderlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherUnderlierID != null ? otherUnderlierID.hashCode() : 0);
			_result = 31 * _result + (underlierID != null ? underlierID.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (notionalCurrency != null ? notionalCurrency.hashCode() : 0);
			_result = 31 * _result + (otherNotionalCurrency != null ? otherNotionalCurrency.hashCode() : 0);
			_result = 31 * _result + (underlierName != null ? underlierName.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbForeign_Exchange {" +
				"UnderlierIDSource=" + this.underlierIDSource + ", " +
				"ReturnorPayoutTrigger=" + this.returnorPayoutTrigger + ", " +
				"PlaceofSettlement=" + this.placeofSettlement + ", " +
				"OtherUnderlierIDSource=" + this.otherUnderlierIDSource + ", " +
				"OtherUnderlierID=" + this.otherUnderlierID + ", " +
				"UnderlierID=" + this.underlierID + ", " +
				"SettlementCurrency=" + this.settlementCurrency + ", " +
				"NotionalCurrency=" + this.notionalCurrency + ", " +
				"OtherNotionalCurrency=" + this.otherNotionalCurrency + ", " +
				"UnderlierName=" + this.underlierName +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbForeign_Exchange  ***********************/
	class AnnaDsbForeign_ExchangeBuilderImpl implements AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder {
	
		protected AnnaDsbUnderlierIDSourceEnum underlierIDSource;
		protected AnnaDsbReturnorPayoutTriggerEnum returnorPayoutTrigger;
		protected AnnaDsbPlaceofSettlementEnum placeofSettlement;
		protected AnnaDsbOtherUnderlierIDSourceEnum otherUnderlierIDSource;
		protected String otherUnderlierID;
		protected String underlierID;
		protected String settlementCurrency;
		protected String notionalCurrency;
		protected String otherNotionalCurrency;
		protected String underlierName;
		
		@Override
		@RosettaAttribute("UnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierIDSource")
		public AnnaDsbUnderlierIDSourceEnum getUnderlierIDSource() {
			return underlierIDSource;
		}
		
		@Override
		@RosettaAttribute("ReturnorPayoutTrigger")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReturnorPayoutTrigger")
		public AnnaDsbReturnorPayoutTriggerEnum getReturnorPayoutTrigger() {
			return returnorPayoutTrigger;
		}
		
		@Override
		@RosettaAttribute("PlaceofSettlement")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("PlaceofSettlement")
		public AnnaDsbPlaceofSettlementEnum getPlaceofSettlement() {
			return placeofSettlement;
		}
		
		@Override
		@RosettaAttribute("OtherUnderlierIDSource")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherUnderlierIDSource")
		public AnnaDsbOtherUnderlierIDSourceEnum getOtherUnderlierIDSource() {
			return otherUnderlierIDSource;
		}
		
		@Override
		@RosettaAttribute("OtherUnderlierID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherUnderlierID")
		public String getOtherUnderlierID() {
			return otherUnderlierID;
		}
		
		@Override
		@RosettaAttribute("UnderlierID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierID")
		public String getUnderlierID() {
			return underlierID;
		}
		
		@Override
		@RosettaAttribute("SettlementCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("SettlementCurrency")
		public String getSettlementCurrency() {
			return settlementCurrency;
		}
		
		@Override
		@RosettaAttribute("NotionalCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("NotionalCurrency")
		public String getNotionalCurrency() {
			return notionalCurrency;
		}
		
		@Override
		@RosettaAttribute("OtherNotionalCurrency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("OtherNotionalCurrency")
		public String getOtherNotionalCurrency() {
			return otherNotionalCurrency;
		}
		
		@Override
		@RosettaAttribute("UnderlierName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierName")
		public String getUnderlierName() {
			return underlierName;
		}
		
		@RosettaAttribute("UnderlierIDSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlierIDSource")
		@Override
		public AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder setUnderlierIDSource(AnnaDsbUnderlierIDSourceEnum _underlierIDSource) {
			this.underlierIDSource = _underlierIDSource == null ? null : _underlierIDSource;
			return this;
		}
		
		@RosettaAttribute("ReturnorPayoutTrigger")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ReturnorPayoutTrigger")
		@Override
		public AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder setReturnorPayoutTrigger(AnnaDsbReturnorPayoutTriggerEnum _returnorPayoutTrigger) {
			this.returnorPayoutTrigger = _returnorPayoutTrigger == null ? null : _returnorPayoutTrigger;
			return this;
		}
		
		@RosettaAttribute("PlaceofSettlement")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("PlaceofSettlement")
		@Override
		public AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder setPlaceofSettlement(AnnaDsbPlaceofSettlementEnum _placeofSettlement) {
			this.placeofSettlement = _placeofSettlement == null ? null : _placeofSettlement;
			return this;
		}
		
		@RosettaAttribute("OtherUnderlierIDSource")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherUnderlierIDSource")
		@Override
		public AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder setOtherUnderlierIDSource(AnnaDsbOtherUnderlierIDSourceEnum _otherUnderlierIDSource) {
			this.otherUnderlierIDSource = _otherUnderlierIDSource == null ? null : _otherUnderlierIDSource;
			return this;
		}
		
		@RosettaAttribute("OtherUnderlierID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherUnderlierID")
		@Override
		public AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder setOtherUnderlierID(String _otherUnderlierID) {
			this.otherUnderlierID = _otherUnderlierID == null ? null : _otherUnderlierID;
			return this;
		}
		
		@RosettaAttribute("UnderlierID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlierID")
		@Override
		public AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder setUnderlierID(String _underlierID) {
			this.underlierID = _underlierID == null ? null : _underlierID;
			return this;
		}
		
		@RosettaAttribute("SettlementCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("SettlementCurrency")
		@Override
		public AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder setSettlementCurrency(String _settlementCurrency) {
			this.settlementCurrency = _settlementCurrency == null ? null : _settlementCurrency;
			return this;
		}
		
		@RosettaAttribute("NotionalCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("NotionalCurrency")
		@Override
		public AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder setNotionalCurrency(String _notionalCurrency) {
			this.notionalCurrency = _notionalCurrency == null ? null : _notionalCurrency;
			return this;
		}
		
		@RosettaAttribute("OtherNotionalCurrency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("OtherNotionalCurrency")
		@Override
		public AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder setOtherNotionalCurrency(String _otherNotionalCurrency) {
			this.otherNotionalCurrency = _otherNotionalCurrency == null ? null : _otherNotionalCurrency;
			return this;
		}
		
		@RosettaAttribute("UnderlierName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlierName")
		@Override
		public AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder setUnderlierName(String _underlierName) {
			this.underlierName = _underlierName == null ? null : _underlierName;
			return this;
		}
		
		@Override
		public AnnaDsbForeign_Exchange build() {
			return new AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeImpl(this);
		}
		
		@Override
		public AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnderlierIDSource()!=null) return true;
			if (getReturnorPayoutTrigger()!=null) return true;
			if (getPlaceofSettlement()!=null) return true;
			if (getOtherUnderlierIDSource()!=null) return true;
			if (getOtherUnderlierID()!=null) return true;
			if (getUnderlierID()!=null) return true;
			if (getSettlementCurrency()!=null) return true;
			if (getNotionalCurrency()!=null) return true;
			if (getOtherNotionalCurrency()!=null) return true;
			if (getUnderlierName()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder o = (AnnaDsbForeign_Exchange.AnnaDsbForeign_ExchangeBuilder) other;
			
			
			merger.mergeBasic(getUnderlierIDSource(), o.getUnderlierIDSource(), this::setUnderlierIDSource);
			merger.mergeBasic(getReturnorPayoutTrigger(), o.getReturnorPayoutTrigger(), this::setReturnorPayoutTrigger);
			merger.mergeBasic(getPlaceofSettlement(), o.getPlaceofSettlement(), this::setPlaceofSettlement);
			merger.mergeBasic(getOtherUnderlierIDSource(), o.getOtherUnderlierIDSource(), this::setOtherUnderlierIDSource);
			merger.mergeBasic(getOtherUnderlierID(), o.getOtherUnderlierID(), this::setOtherUnderlierID);
			merger.mergeBasic(getUnderlierID(), o.getUnderlierID(), this::setUnderlierID);
			merger.mergeBasic(getSettlementCurrency(), o.getSettlementCurrency(), this::setSettlementCurrency);
			merger.mergeBasic(getNotionalCurrency(), o.getNotionalCurrency(), this::setNotionalCurrency);
			merger.mergeBasic(getOtherNotionalCurrency(), o.getOtherNotionalCurrency(), this::setOtherNotionalCurrency);
			merger.mergeBasic(getUnderlierName(), o.getUnderlierName(), this::setUnderlierName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbForeign_Exchange _that = getType().cast(o);
		
			if (!Objects.equals(underlierIDSource, _that.getUnderlierIDSource())) return false;
			if (!Objects.equals(returnorPayoutTrigger, _that.getReturnorPayoutTrigger())) return false;
			if (!Objects.equals(placeofSettlement, _that.getPlaceofSettlement())) return false;
			if (!Objects.equals(otherUnderlierIDSource, _that.getOtherUnderlierIDSource())) return false;
			if (!Objects.equals(otherUnderlierID, _that.getOtherUnderlierID())) return false;
			if (!Objects.equals(underlierID, _that.getUnderlierID())) return false;
			if (!Objects.equals(settlementCurrency, _that.getSettlementCurrency())) return false;
			if (!Objects.equals(notionalCurrency, _that.getNotionalCurrency())) return false;
			if (!Objects.equals(otherNotionalCurrency, _that.getOtherNotionalCurrency())) return false;
			if (!Objects.equals(underlierName, _that.getUnderlierName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlierIDSource != null ? underlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (returnorPayoutTrigger != null ? returnorPayoutTrigger.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (placeofSettlement != null ? placeofSettlement.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherUnderlierIDSource != null ? otherUnderlierIDSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (otherUnderlierID != null ? otherUnderlierID.hashCode() : 0);
			_result = 31 * _result + (underlierID != null ? underlierID.hashCode() : 0);
			_result = 31 * _result + (settlementCurrency != null ? settlementCurrency.hashCode() : 0);
			_result = 31 * _result + (notionalCurrency != null ? notionalCurrency.hashCode() : 0);
			_result = 31 * _result + (otherNotionalCurrency != null ? otherNotionalCurrency.hashCode() : 0);
			_result = 31 * _result + (underlierName != null ? underlierName.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbForeign_ExchangeBuilder {" +
				"UnderlierIDSource=" + this.underlierIDSource + ", " +
				"ReturnorPayoutTrigger=" + this.returnorPayoutTrigger + ", " +
				"PlaceofSettlement=" + this.placeofSettlement + ", " +
				"OtherUnderlierIDSource=" + this.otherUnderlierIDSource + ", " +
				"OtherUnderlierID=" + this.otherUnderlierID + ", " +
				"UnderlierID=" + this.underlierID + ", " +
				"SettlementCurrency=" + this.settlementCurrency + ", " +
				"NotionalCurrency=" + this.notionalCurrency + ", " +
				"OtherNotionalCurrency=" + this.otherNotionalCurrency + ", " +
				"UnderlierName=" + this.underlierName +
			'}';
		}
	}
}
