package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.LegacyTransferSettlementTimingMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specification of transfer / settlement timing for cash and securities collateral assuming that the notice is provided before the Notification Time (and with a 1LBD lag introduced if the notice is delivered after the Notification Time), and that securities allow for a further Local Business Day for transfer / settlement.
 * @version 6.23.0
 */
@RosettaDataType(value="LegacyTransferSettlementTiming", builder=LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilderImpl.class, version="6.23.0")
@RuneDataType(value="LegacyTransferSettlementTiming", model="cdm", builder=LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilderImpl.class, version="6.23.0")
public interface LegacyTransferSettlementTiming extends RosettaModelObject {

	LegacyTransferSettlementTimingMeta metaData = new LegacyTransferSettlementTimingMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Details the day on which collateral is required to be transferred relative to the Notification Time.
	 */
	CashCTSTimeEnum getCashCollateralTransferSettlementTime();
	/**
	 * Details the day on which collateral is required to be transferred relative to the Notification Time.
	 */
	SecuritiesCTSTimeEnum getSecurititesCollateralTransferSettlementTime();
	/**
	 * The additional language that might be specified by the parties to the legal agreement.
	 */
	String getAdditionalLanguage();

	/*********************** Build Methods  ***********************/
	LegacyTransferSettlementTiming build();
	
	LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder toBuilder();
	
	static LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder builder() {
		return new LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegacyTransferSettlementTiming> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LegacyTransferSettlementTiming> getType() {
		return LegacyTransferSettlementTiming.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cashCollateralTransferSettlementTime"), CashCTSTimeEnum.class, getCashCollateralTransferSettlementTime(), this);
		processor.processBasic(path.newSubPath("securititesCollateralTransferSettlementTime"), SecuritiesCTSTimeEnum.class, getSecurititesCollateralTransferSettlementTime(), this);
		processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegacyTransferSettlementTimingBuilder extends LegacyTransferSettlementTiming, RosettaModelObjectBuilder {
		LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder setCashCollateralTransferSettlementTime(CashCTSTimeEnum cashCollateralTransferSettlementTime);
		LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder setSecurititesCollateralTransferSettlementTime(SecuritiesCTSTimeEnum securititesCollateralTransferSettlementTime);
		LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder setAdditionalLanguage(String additionalLanguage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("cashCollateralTransferSettlementTime"), CashCTSTimeEnum.class, getCashCollateralTransferSettlementTime(), this);
			processor.processBasic(path.newSubPath("securititesCollateralTransferSettlementTime"), SecuritiesCTSTimeEnum.class, getSecurititesCollateralTransferSettlementTime(), this);
			processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
		}
		

		LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder prune();
	}

	/*********************** Immutable Implementation of LegacyTransferSettlementTiming  ***********************/
	class LegacyTransferSettlementTimingImpl implements LegacyTransferSettlementTiming {
		private final CashCTSTimeEnum cashCollateralTransferSettlementTime;
		private final SecuritiesCTSTimeEnum securititesCollateralTransferSettlementTime;
		private final String additionalLanguage;
		
		protected LegacyTransferSettlementTimingImpl(LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder builder) {
			this.cashCollateralTransferSettlementTime = builder.getCashCollateralTransferSettlementTime();
			this.securititesCollateralTransferSettlementTime = builder.getSecurititesCollateralTransferSettlementTime();
			this.additionalLanguage = builder.getAdditionalLanguage();
		}
		
		@Override
		@RosettaAttribute("cashCollateralTransferSettlementTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashCollateralTransferSettlementTime")
		public CashCTSTimeEnum getCashCollateralTransferSettlementTime() {
			return cashCollateralTransferSettlementTime;
		}
		
		@Override
		@RosettaAttribute("securititesCollateralTransferSettlementTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("securititesCollateralTransferSettlementTime")
		public SecuritiesCTSTimeEnum getSecurititesCollateralTransferSettlementTime() {
			return securititesCollateralTransferSettlementTime;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@Override
		public LegacyTransferSettlementTiming build() {
			return this;
		}
		
		@Override
		public LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder toBuilder() {
			LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder builder) {
			ofNullable(getCashCollateralTransferSettlementTime()).ifPresent(builder::setCashCollateralTransferSettlementTime);
			ofNullable(getSecurititesCollateralTransferSettlementTime()).ifPresent(builder::setSecurititesCollateralTransferSettlementTime);
			ofNullable(getAdditionalLanguage()).ifPresent(builder::setAdditionalLanguage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegacyTransferSettlementTiming _that = getType().cast(o);
		
			if (!Objects.equals(cashCollateralTransferSettlementTime, _that.getCashCollateralTransferSettlementTime())) return false;
			if (!Objects.equals(securititesCollateralTransferSettlementTime, _that.getSecurititesCollateralTransferSettlementTime())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashCollateralTransferSettlementTime != null ? cashCollateralTransferSettlementTime.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (securititesCollateralTransferSettlementTime != null ? securititesCollateralTransferSettlementTime.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyTransferSettlementTiming {" +
				"cashCollateralTransferSettlementTime=" + this.cashCollateralTransferSettlementTime + ", " +
				"securititesCollateralTransferSettlementTime=" + this.securititesCollateralTransferSettlementTime + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}

	/*********************** Builder Implementation of LegacyTransferSettlementTiming  ***********************/
	class LegacyTransferSettlementTimingBuilderImpl implements LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder {
	
		protected CashCTSTimeEnum cashCollateralTransferSettlementTime;
		protected SecuritiesCTSTimeEnum securititesCollateralTransferSettlementTime;
		protected String additionalLanguage;
		
		@Override
		@RosettaAttribute("cashCollateralTransferSettlementTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashCollateralTransferSettlementTime")
		public CashCTSTimeEnum getCashCollateralTransferSettlementTime() {
			return cashCollateralTransferSettlementTime;
		}
		
		@Override
		@RosettaAttribute("securititesCollateralTransferSettlementTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("securititesCollateralTransferSettlementTime")
		public SecuritiesCTSTimeEnum getSecurititesCollateralTransferSettlementTime() {
			return securititesCollateralTransferSettlementTime;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@RosettaAttribute("cashCollateralTransferSettlementTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashCollateralTransferSettlementTime")
		@Override
		public LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder setCashCollateralTransferSettlementTime(CashCTSTimeEnum _cashCollateralTransferSettlementTime) {
			this.cashCollateralTransferSettlementTime = _cashCollateralTransferSettlementTime == null ? null : _cashCollateralTransferSettlementTime;
			return this;
		}
		
		@RosettaAttribute("securititesCollateralTransferSettlementTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("securititesCollateralTransferSettlementTime")
		@Override
		public LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder setSecurititesCollateralTransferSettlementTime(SecuritiesCTSTimeEnum _securititesCollateralTransferSettlementTime) {
			this.securititesCollateralTransferSettlementTime = _securititesCollateralTransferSettlementTime == null ? null : _securititesCollateralTransferSettlementTime;
			return this;
		}
		
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalLanguage")
		@Override
		public LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder setAdditionalLanguage(String _additionalLanguage) {
			this.additionalLanguage = _additionalLanguage == null ? null : _additionalLanguage;
			return this;
		}
		
		@Override
		public LegacyTransferSettlementTiming build() {
			return new LegacyTransferSettlementTiming.LegacyTransferSettlementTimingImpl(this);
		}
		
		@Override
		public LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCashCollateralTransferSettlementTime()!=null) return true;
			if (getSecurititesCollateralTransferSettlementTime()!=null) return true;
			if (getAdditionalLanguage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder o = (LegacyTransferSettlementTiming.LegacyTransferSettlementTimingBuilder) other;
			
			
			merger.mergeBasic(getCashCollateralTransferSettlementTime(), o.getCashCollateralTransferSettlementTime(), this::setCashCollateralTransferSettlementTime);
			merger.mergeBasic(getSecurititesCollateralTransferSettlementTime(), o.getSecurititesCollateralTransferSettlementTime(), this::setSecurititesCollateralTransferSettlementTime);
			merger.mergeBasic(getAdditionalLanguage(), o.getAdditionalLanguage(), this::setAdditionalLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegacyTransferSettlementTiming _that = getType().cast(o);
		
			if (!Objects.equals(cashCollateralTransferSettlementTime, _that.getCashCollateralTransferSettlementTime())) return false;
			if (!Objects.equals(securititesCollateralTransferSettlementTime, _that.getSecurititesCollateralTransferSettlementTime())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashCollateralTransferSettlementTime != null ? cashCollateralTransferSettlementTime.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (securititesCollateralTransferSettlementTime != null ? securititesCollateralTransferSettlementTime.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyTransferSettlementTimingBuilder {" +
				"cashCollateralTransferSettlementTime=" + this.cashCollateralTransferSettlementTime + ", " +
				"securititesCollateralTransferSettlementTime=" + this.securititesCollateralTransferSettlementTime + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}
}
