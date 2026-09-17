package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.LegacyResolutionValueMeta;
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
 * Methodology for resolving disputes in respect of the determination of the value of collateral.
 * @version 6.23.0
 */
@RosettaDataType(value="LegacyResolutionValue", builder=LegacyResolutionValue.LegacyResolutionValueBuilderImpl.class, version="6.23.0")
@RuneDataType(value="LegacyResolutionValue", model="cdm", builder=LegacyResolutionValue.LegacyResolutionValueBuilderImpl.class, version="6.23.0")
public interface LegacyResolutionValue extends RosettaModelObject {

	LegacyResolutionValueMeta metaData = new LegacyResolutionValueMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Details of how cash collateral is valued when resolving disputes.
	 */
	ValueCashEnum getCash();
	/**
	 * Details of how securities collateral is valued when resolving disputes.
	 */
	ValueSecuritiesEnum getSecurities();
	/**
	 * A boolean flag to represent whether a fallback calculation method is applicable.
	 */
	Boolean getFallback();
	/**
	 * The additional language that might be specified by the parties to the legal agreement.
	 */
	String getAdditionalLanguage();

	/*********************** Build Methods  ***********************/
	LegacyResolutionValue build();
	
	LegacyResolutionValue.LegacyResolutionValueBuilder toBuilder();
	
	static LegacyResolutionValue.LegacyResolutionValueBuilder builder() {
		return new LegacyResolutionValue.LegacyResolutionValueBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegacyResolutionValue> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LegacyResolutionValue> getType() {
		return LegacyResolutionValue.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cash"), ValueCashEnum.class, getCash(), this);
		processor.processBasic(path.newSubPath("securities"), ValueSecuritiesEnum.class, getSecurities(), this);
		processor.processBasic(path.newSubPath("fallback"), Boolean.class, getFallback(), this);
		processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegacyResolutionValueBuilder extends LegacyResolutionValue, RosettaModelObjectBuilder {
		LegacyResolutionValue.LegacyResolutionValueBuilder setCash(ValueCashEnum cash);
		LegacyResolutionValue.LegacyResolutionValueBuilder setSecurities(ValueSecuritiesEnum securities);
		LegacyResolutionValue.LegacyResolutionValueBuilder setFallback(Boolean fallback);
		LegacyResolutionValue.LegacyResolutionValueBuilder setAdditionalLanguage(String additionalLanguage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("cash"), ValueCashEnum.class, getCash(), this);
			processor.processBasic(path.newSubPath("securities"), ValueSecuritiesEnum.class, getSecurities(), this);
			processor.processBasic(path.newSubPath("fallback"), Boolean.class, getFallback(), this);
			processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
		}
		

		LegacyResolutionValue.LegacyResolutionValueBuilder prune();
	}

	/*********************** Immutable Implementation of LegacyResolutionValue  ***********************/
	class LegacyResolutionValueImpl implements LegacyResolutionValue {
		private final ValueCashEnum cash;
		private final ValueSecuritiesEnum securities;
		private final Boolean fallback;
		private final String additionalLanguage;
		
		protected LegacyResolutionValueImpl(LegacyResolutionValue.LegacyResolutionValueBuilder builder) {
			this.cash = builder.getCash();
			this.securities = builder.getSecurities();
			this.fallback = builder.getFallback();
			this.additionalLanguage = builder.getAdditionalLanguage();
		}
		
		@Override
		@RosettaAttribute("cash")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cash")
		public ValueCashEnum getCash() {
			return cash;
		}
		
		@Override
		@RosettaAttribute("securities")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("securities")
		public ValueSecuritiesEnum getSecurities() {
			return securities;
		}
		
		@Override
		@RosettaAttribute("fallback")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fallback")
		public Boolean getFallback() {
			return fallback;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@Override
		public LegacyResolutionValue build() {
			return this;
		}
		
		@Override
		public LegacyResolutionValue.LegacyResolutionValueBuilder toBuilder() {
			LegacyResolutionValue.LegacyResolutionValueBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegacyResolutionValue.LegacyResolutionValueBuilder builder) {
			ofNullable(getCash()).ifPresent(builder::setCash);
			ofNullable(getSecurities()).ifPresent(builder::setSecurities);
			ofNullable(getFallback()).ifPresent(builder::setFallback);
			ofNullable(getAdditionalLanguage()).ifPresent(builder::setAdditionalLanguage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegacyResolutionValue _that = getType().cast(o);
		
			if (!Objects.equals(cash, _that.getCash())) return false;
			if (!Objects.equals(securities, _that.getSecurities())) return false;
			if (!Objects.equals(fallback, _that.getFallback())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cash != null ? cash.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (securities != null ? securities.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fallback != null ? fallback.hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyResolutionValue {" +
				"cash=" + this.cash + ", " +
				"securities=" + this.securities + ", " +
				"fallback=" + this.fallback + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}

	/*********************** Builder Implementation of LegacyResolutionValue  ***********************/
	class LegacyResolutionValueBuilderImpl implements LegacyResolutionValue.LegacyResolutionValueBuilder {
	
		protected ValueCashEnum cash;
		protected ValueSecuritiesEnum securities;
		protected Boolean fallback;
		protected String additionalLanguage;
		
		@Override
		@RosettaAttribute("cash")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cash")
		public ValueCashEnum getCash() {
			return cash;
		}
		
		@Override
		@RosettaAttribute("securities")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("securities")
		public ValueSecuritiesEnum getSecurities() {
			return securities;
		}
		
		@Override
		@RosettaAttribute("fallback")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fallback")
		public Boolean getFallback() {
			return fallback;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@RosettaAttribute("cash")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cash")
		@Override
		public LegacyResolutionValue.LegacyResolutionValueBuilder setCash(ValueCashEnum _cash) {
			this.cash = _cash == null ? null : _cash;
			return this;
		}
		
		@RosettaAttribute("securities")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("securities")
		@Override
		public LegacyResolutionValue.LegacyResolutionValueBuilder setSecurities(ValueSecuritiesEnum _securities) {
			this.securities = _securities == null ? null : _securities;
			return this;
		}
		
		@RosettaAttribute("fallback")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fallback")
		@Override
		public LegacyResolutionValue.LegacyResolutionValueBuilder setFallback(Boolean _fallback) {
			this.fallback = _fallback == null ? null : _fallback;
			return this;
		}
		
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalLanguage")
		@Override
		public LegacyResolutionValue.LegacyResolutionValueBuilder setAdditionalLanguage(String _additionalLanguage) {
			this.additionalLanguage = _additionalLanguage == null ? null : _additionalLanguage;
			return this;
		}
		
		@Override
		public LegacyResolutionValue build() {
			return new LegacyResolutionValue.LegacyResolutionValueImpl(this);
		}
		
		@Override
		public LegacyResolutionValue.LegacyResolutionValueBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyResolutionValue.LegacyResolutionValueBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCash()!=null) return true;
			if (getSecurities()!=null) return true;
			if (getFallback()!=null) return true;
			if (getAdditionalLanguage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyResolutionValue.LegacyResolutionValueBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegacyResolutionValue.LegacyResolutionValueBuilder o = (LegacyResolutionValue.LegacyResolutionValueBuilder) other;
			
			
			merger.mergeBasic(getCash(), o.getCash(), this::setCash);
			merger.mergeBasic(getSecurities(), o.getSecurities(), this::setSecurities);
			merger.mergeBasic(getFallback(), o.getFallback(), this::setFallback);
			merger.mergeBasic(getAdditionalLanguage(), o.getAdditionalLanguage(), this::setAdditionalLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegacyResolutionValue _that = getType().cast(o);
		
			if (!Objects.equals(cash, _that.getCash())) return false;
			if (!Objects.equals(securities, _that.getSecurities())) return false;
			if (!Objects.equals(fallback, _that.getFallback())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cash != null ? cash.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (securities != null ? securities.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fallback != null ? fallback.hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyResolutionValueBuilder {" +
				"cash=" + this.cash + ", " +
				"securities=" + this.securities + ", " +
				"fallback=" + this.fallback + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}
}
