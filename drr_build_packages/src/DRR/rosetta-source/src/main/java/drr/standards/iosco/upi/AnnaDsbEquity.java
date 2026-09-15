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
import drr.standards.iosco.upi.meta.AnnaDsbEquityMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbEquity", builder=AnnaDsbEquity.AnnaDsbEquityBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbEquity", model="drr", builder=AnnaDsbEquity.AnnaDsbEquityBuilderImpl.class, version="7.7.0")
public interface AnnaDsbEquity extends RosettaModelObject {

	AnnaDsbEquityMeta metaData = new AnnaDsbEquityMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbReturnorPayoutTriggerEnum getReturnorPayoutTrigger();
	AnnaDsbUnderlierCharacteristicEnum getUnderlierCharacteristic();
	AnnaDsbUnderlying getUnderlying();
	String getUnderlyingInstrumentISIN();
	String getUnderlyingInstrumentIndex();
	String getUnderlyingInstrumentIndexProp();
	String getUnderlierName();

	/*********************** Build Methods  ***********************/
	AnnaDsbEquity build();
	
	AnnaDsbEquity.AnnaDsbEquityBuilder toBuilder();
	
	static AnnaDsbEquity.AnnaDsbEquityBuilder builder() {
		return new AnnaDsbEquity.AnnaDsbEquityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbEquity> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbEquity> getType() {
		return AnnaDsbEquity.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("ReturnorPayoutTrigger"), AnnaDsbReturnorPayoutTriggerEnum.class, getReturnorPayoutTrigger(), this);
		processor.processBasic(path.newSubPath("UnderlierCharacteristic"), AnnaDsbUnderlierCharacteristicEnum.class, getUnderlierCharacteristic(), this);
		processRosetta(path.newSubPath("Underlying"), processor, AnnaDsbUnderlying.class, getUnderlying());
		processor.processBasic(path.newSubPath("UnderlyingInstrumentISIN"), String.class, getUnderlyingInstrumentISIN(), this);
		processor.processBasic(path.newSubPath("UnderlyingInstrumentIndex"), String.class, getUnderlyingInstrumentIndex(), this);
		processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexProp"), String.class, getUnderlyingInstrumentIndexProp(), this);
		processor.processBasic(path.newSubPath("UnderlierName"), String.class, getUnderlierName(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbEquityBuilder extends AnnaDsbEquity, RosettaModelObjectBuilder {
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder getOrCreateUnderlying();
		@Override
		AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder getUnderlying();
		AnnaDsbEquity.AnnaDsbEquityBuilder setReturnorPayoutTrigger(AnnaDsbReturnorPayoutTriggerEnum ReturnorPayoutTrigger);
		AnnaDsbEquity.AnnaDsbEquityBuilder setUnderlierCharacteristic(AnnaDsbUnderlierCharacteristicEnum UnderlierCharacteristic);
		AnnaDsbEquity.AnnaDsbEquityBuilder setUnderlying(AnnaDsbUnderlying Underlying);
		AnnaDsbEquity.AnnaDsbEquityBuilder setUnderlyingInstrumentISIN(String UnderlyingInstrumentISIN);
		AnnaDsbEquity.AnnaDsbEquityBuilder setUnderlyingInstrumentIndex(String UnderlyingInstrumentIndex);
		AnnaDsbEquity.AnnaDsbEquityBuilder setUnderlyingInstrumentIndexProp(String UnderlyingInstrumentIndexProp);
		AnnaDsbEquity.AnnaDsbEquityBuilder setUnderlierName(String UnderlierName);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("ReturnorPayoutTrigger"), AnnaDsbReturnorPayoutTriggerEnum.class, getReturnorPayoutTrigger(), this);
			processor.processBasic(path.newSubPath("UnderlierCharacteristic"), AnnaDsbUnderlierCharacteristicEnum.class, getUnderlierCharacteristic(), this);
			processRosetta(path.newSubPath("Underlying"), processor, AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder.class, getUnderlying());
			processor.processBasic(path.newSubPath("UnderlyingInstrumentISIN"), String.class, getUnderlyingInstrumentISIN(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentIndex"), String.class, getUnderlyingInstrumentIndex(), this);
			processor.processBasic(path.newSubPath("UnderlyingInstrumentIndexProp"), String.class, getUnderlyingInstrumentIndexProp(), this);
			processor.processBasic(path.newSubPath("UnderlierName"), String.class, getUnderlierName(), this);
		}
		

		AnnaDsbEquity.AnnaDsbEquityBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbEquity  ***********************/
	class AnnaDsbEquityImpl implements AnnaDsbEquity {
		private final AnnaDsbReturnorPayoutTriggerEnum returnorPayoutTrigger;
		private final AnnaDsbUnderlierCharacteristicEnum underlierCharacteristic;
		private final AnnaDsbUnderlying underlying;
		private final String underlyingInstrumentISIN;
		private final String underlyingInstrumentIndex;
		private final String underlyingInstrumentIndexProp;
		private final String underlierName;
		
		protected AnnaDsbEquityImpl(AnnaDsbEquity.AnnaDsbEquityBuilder builder) {
			this.returnorPayoutTrigger = builder.getReturnorPayoutTrigger();
			this.underlierCharacteristic = builder.getUnderlierCharacteristic();
			this.underlying = ofNullable(builder.getUnderlying()).map(f->f.build()).orElse(null);
			this.underlyingInstrumentISIN = builder.getUnderlyingInstrumentISIN();
			this.underlyingInstrumentIndex = builder.getUnderlyingInstrumentIndex();
			this.underlyingInstrumentIndexProp = builder.getUnderlyingInstrumentIndexProp();
			this.underlierName = builder.getUnderlierName();
		}
		
		@Override
		@RosettaAttribute("ReturnorPayoutTrigger")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReturnorPayoutTrigger")
		public AnnaDsbReturnorPayoutTriggerEnum getReturnorPayoutTrigger() {
			return returnorPayoutTrigger;
		}
		
		@Override
		@RosettaAttribute("UnderlierCharacteristic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierCharacteristic")
		public AnnaDsbUnderlierCharacteristicEnum getUnderlierCharacteristic() {
			return underlierCharacteristic;
		}
		
		@Override
		@RosettaAttribute("Underlying")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Underlying")
		public AnnaDsbUnderlying getUnderlying() {
			return underlying;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentISIN")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentISIN")
		public String getUnderlyingInstrumentISIN() {
			return underlyingInstrumentISIN;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndex")
		public String getUnderlyingInstrumentIndex() {
			return underlyingInstrumentIndex;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndexProp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndexProp")
		public String getUnderlyingInstrumentIndexProp() {
			return underlyingInstrumentIndexProp;
		}
		
		@Override
		@RosettaAttribute("UnderlierName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierName")
		public String getUnderlierName() {
			return underlierName;
		}
		
		@Override
		public AnnaDsbEquity build() {
			return this;
		}
		
		@Override
		public AnnaDsbEquity.AnnaDsbEquityBuilder toBuilder() {
			AnnaDsbEquity.AnnaDsbEquityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbEquity.AnnaDsbEquityBuilder builder) {
			ofNullable(getReturnorPayoutTrigger()).ifPresent(builder::setReturnorPayoutTrigger);
			ofNullable(getUnderlierCharacteristic()).ifPresent(builder::setUnderlierCharacteristic);
			ofNullable(getUnderlying()).ifPresent(builder::setUnderlying);
			ofNullable(getUnderlyingInstrumentISIN()).ifPresent(builder::setUnderlyingInstrumentISIN);
			ofNullable(getUnderlyingInstrumentIndex()).ifPresent(builder::setUnderlyingInstrumentIndex);
			ofNullable(getUnderlyingInstrumentIndexProp()).ifPresent(builder::setUnderlyingInstrumentIndexProp);
			ofNullable(getUnderlierName()).ifPresent(builder::setUnderlierName);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbEquity _that = getType().cast(o);
		
			if (!Objects.equals(returnorPayoutTrigger, _that.getReturnorPayoutTrigger())) return false;
			if (!Objects.equals(underlierCharacteristic, _that.getUnderlierCharacteristic())) return false;
			if (!Objects.equals(underlying, _that.getUnderlying())) return false;
			if (!Objects.equals(underlyingInstrumentISIN, _that.getUnderlyingInstrumentISIN())) return false;
			if (!Objects.equals(underlyingInstrumentIndex, _that.getUnderlyingInstrumentIndex())) return false;
			if (!Objects.equals(underlyingInstrumentIndexProp, _that.getUnderlyingInstrumentIndexProp())) return false;
			if (!Objects.equals(underlierName, _that.getUnderlierName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (returnorPayoutTrigger != null ? returnorPayoutTrigger.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlierCharacteristic != null ? underlierCharacteristic.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlying != null ? underlying.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentISIN != null ? underlyingInstrumentISIN.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndex != null ? underlyingInstrumentIndex.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexProp != null ? underlyingInstrumentIndexProp.hashCode() : 0);
			_result = 31 * _result + (underlierName != null ? underlierName.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbEquity {" +
				"ReturnorPayoutTrigger=" + this.returnorPayoutTrigger + ", " +
				"UnderlierCharacteristic=" + this.underlierCharacteristic + ", " +
				"Underlying=" + this.underlying + ", " +
				"UnderlyingInstrumentISIN=" + this.underlyingInstrumentISIN + ", " +
				"UnderlyingInstrumentIndex=" + this.underlyingInstrumentIndex + ", " +
				"UnderlyingInstrumentIndexProp=" + this.underlyingInstrumentIndexProp + ", " +
				"UnderlierName=" + this.underlierName +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbEquity  ***********************/
	class AnnaDsbEquityBuilderImpl implements AnnaDsbEquity.AnnaDsbEquityBuilder {
	
		protected AnnaDsbReturnorPayoutTriggerEnum returnorPayoutTrigger;
		protected AnnaDsbUnderlierCharacteristicEnum underlierCharacteristic;
		protected AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder underlying;
		protected String underlyingInstrumentISIN;
		protected String underlyingInstrumentIndex;
		protected String underlyingInstrumentIndexProp;
		protected String underlierName;
		
		@Override
		@RosettaAttribute("ReturnorPayoutTrigger")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ReturnorPayoutTrigger")
		public AnnaDsbReturnorPayoutTriggerEnum getReturnorPayoutTrigger() {
			return returnorPayoutTrigger;
		}
		
		@Override
		@RosettaAttribute("UnderlierCharacteristic")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierCharacteristic")
		public AnnaDsbUnderlierCharacteristicEnum getUnderlierCharacteristic() {
			return underlierCharacteristic;
		}
		
		@Override
		@RosettaAttribute("Underlying")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("Underlying")
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder getUnderlying() {
			return underlying;
		}
		
		@Override
		public AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder getOrCreateUnderlying() {
			AnnaDsbUnderlying.AnnaDsbUnderlyingBuilder result;
			if (underlying!=null) {
				result = underlying;
			}
			else {
				result = underlying = AnnaDsbUnderlying.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentISIN")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentISIN")
		public String getUnderlyingInstrumentISIN() {
			return underlyingInstrumentISIN;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndex")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndex")
		public String getUnderlyingInstrumentIndex() {
			return underlyingInstrumentIndex;
		}
		
		@Override
		@RosettaAttribute("UnderlyingInstrumentIndexProp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlyingInstrumentIndexProp")
		public String getUnderlyingInstrumentIndexProp() {
			return underlyingInstrumentIndexProp;
		}
		
		@Override
		@RosettaAttribute("UnderlierName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("UnderlierName")
		public String getUnderlierName() {
			return underlierName;
		}
		
		@RosettaAttribute("ReturnorPayoutTrigger")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ReturnorPayoutTrigger")
		@Override
		public AnnaDsbEquity.AnnaDsbEquityBuilder setReturnorPayoutTrigger(AnnaDsbReturnorPayoutTriggerEnum _returnorPayoutTrigger) {
			this.returnorPayoutTrigger = _returnorPayoutTrigger == null ? null : _returnorPayoutTrigger;
			return this;
		}
		
		@RosettaAttribute("UnderlierCharacteristic")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlierCharacteristic")
		@Override
		public AnnaDsbEquity.AnnaDsbEquityBuilder setUnderlierCharacteristic(AnnaDsbUnderlierCharacteristicEnum _underlierCharacteristic) {
			this.underlierCharacteristic = _underlierCharacteristic == null ? null : _underlierCharacteristic;
			return this;
		}
		
		@RosettaAttribute("Underlying")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("Underlying")
		@Override
		public AnnaDsbEquity.AnnaDsbEquityBuilder setUnderlying(AnnaDsbUnderlying _underlying) {
			this.underlying = _underlying == null ? null : _underlying.toBuilder();
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentISIN")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentISIN")
		@Override
		public AnnaDsbEquity.AnnaDsbEquityBuilder setUnderlyingInstrumentISIN(String _underlyingInstrumentISIN) {
			this.underlyingInstrumentISIN = _underlyingInstrumentISIN == null ? null : _underlyingInstrumentISIN;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentIndex")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentIndex")
		@Override
		public AnnaDsbEquity.AnnaDsbEquityBuilder setUnderlyingInstrumentIndex(String _underlyingInstrumentIndex) {
			this.underlyingInstrumentIndex = _underlyingInstrumentIndex == null ? null : _underlyingInstrumentIndex;
			return this;
		}
		
		@RosettaAttribute("UnderlyingInstrumentIndexProp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlyingInstrumentIndexProp")
		@Override
		public AnnaDsbEquity.AnnaDsbEquityBuilder setUnderlyingInstrumentIndexProp(String _underlyingInstrumentIndexProp) {
			this.underlyingInstrumentIndexProp = _underlyingInstrumentIndexProp == null ? null : _underlyingInstrumentIndexProp;
			return this;
		}
		
		@RosettaAttribute("UnderlierName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("UnderlierName")
		@Override
		public AnnaDsbEquity.AnnaDsbEquityBuilder setUnderlierName(String _underlierName) {
			this.underlierName = _underlierName == null ? null : _underlierName;
			return this;
		}
		
		@Override
		public AnnaDsbEquity build() {
			return new AnnaDsbEquity.AnnaDsbEquityImpl(this);
		}
		
		@Override
		public AnnaDsbEquity.AnnaDsbEquityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbEquity.AnnaDsbEquityBuilder prune() {
			if (underlying!=null && !underlying.prune().hasData()) underlying = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReturnorPayoutTrigger()!=null) return true;
			if (getUnderlierCharacteristic()!=null) return true;
			if (getUnderlying()!=null && getUnderlying().hasData()) return true;
			if (getUnderlyingInstrumentISIN()!=null) return true;
			if (getUnderlyingInstrumentIndex()!=null) return true;
			if (getUnderlyingInstrumentIndexProp()!=null) return true;
			if (getUnderlierName()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbEquity.AnnaDsbEquityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbEquity.AnnaDsbEquityBuilder o = (AnnaDsbEquity.AnnaDsbEquityBuilder) other;
			
			merger.mergeRosetta(getUnderlying(), o.getUnderlying(), this::setUnderlying);
			
			merger.mergeBasic(getReturnorPayoutTrigger(), o.getReturnorPayoutTrigger(), this::setReturnorPayoutTrigger);
			merger.mergeBasic(getUnderlierCharacteristic(), o.getUnderlierCharacteristic(), this::setUnderlierCharacteristic);
			merger.mergeBasic(getUnderlyingInstrumentISIN(), o.getUnderlyingInstrumentISIN(), this::setUnderlyingInstrumentISIN);
			merger.mergeBasic(getUnderlyingInstrumentIndex(), o.getUnderlyingInstrumentIndex(), this::setUnderlyingInstrumentIndex);
			merger.mergeBasic(getUnderlyingInstrumentIndexProp(), o.getUnderlyingInstrumentIndexProp(), this::setUnderlyingInstrumentIndexProp);
			merger.mergeBasic(getUnderlierName(), o.getUnderlierName(), this::setUnderlierName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbEquity _that = getType().cast(o);
		
			if (!Objects.equals(returnorPayoutTrigger, _that.getReturnorPayoutTrigger())) return false;
			if (!Objects.equals(underlierCharacteristic, _that.getUnderlierCharacteristic())) return false;
			if (!Objects.equals(underlying, _that.getUnderlying())) return false;
			if (!Objects.equals(underlyingInstrumentISIN, _that.getUnderlyingInstrumentISIN())) return false;
			if (!Objects.equals(underlyingInstrumentIndex, _that.getUnderlyingInstrumentIndex())) return false;
			if (!Objects.equals(underlyingInstrumentIndexProp, _that.getUnderlyingInstrumentIndexProp())) return false;
			if (!Objects.equals(underlierName, _that.getUnderlierName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (returnorPayoutTrigger != null ? returnorPayoutTrigger.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlierCharacteristic != null ? underlierCharacteristic.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (underlying != null ? underlying.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentISIN != null ? underlyingInstrumentISIN.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndex != null ? underlyingInstrumentIndex.hashCode() : 0);
			_result = 31 * _result + (underlyingInstrumentIndexProp != null ? underlyingInstrumentIndexProp.hashCode() : 0);
			_result = 31 * _result + (underlierName != null ? underlierName.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbEquityBuilder {" +
				"ReturnorPayoutTrigger=" + this.returnorPayoutTrigger + ", " +
				"UnderlierCharacteristic=" + this.underlierCharacteristic + ", " +
				"Underlying=" + this.underlying + ", " +
				"UnderlyingInstrumentISIN=" + this.underlyingInstrumentISIN + ", " +
				"UnderlyingInstrumentIndex=" + this.underlyingInstrumentIndex + ", " +
				"UnderlyingInstrumentIndexProp=" + this.underlyingInstrumentIndexProp + ", " +
				"UnderlierName=" + this.underlierName +
			'}';
		}
	}
}
