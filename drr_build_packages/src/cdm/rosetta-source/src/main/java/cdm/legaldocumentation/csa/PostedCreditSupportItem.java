package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.PostedCreditSupportItemMeta;
import cdm.observable.asset.Money;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Posted Credit Support item with corresponding Valuation Percentage, FX Haircut Percentage and any related disputed Posted Credit Support valuation.
 * @version 6.23.0
 */
@RosettaDataType(value="PostedCreditSupportItem", builder=PostedCreditSupportItem.PostedCreditSupportItemBuilderImpl.class, version="6.23.0")
@RuneDataType(value="PostedCreditSupportItem", model="cdm", builder=PostedCreditSupportItem.PostedCreditSupportItemBuilderImpl.class, version="6.23.0")
public interface PostedCreditSupportItem extends RosettaModelObject {

	PostedCreditSupportItemMeta metaData = new PostedCreditSupportItemMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Base Currency Equivalent of Cash or Security.
	 */
	Money getCashOrSecurityValue();
	/**
	 * Valuation Percentage means, for any item of Eligible Collateral (IM), the percentage specified in accordance with Paragraph 13.
	 */
	BigDecimal getHaircutPercentage();
	/**
	 * FX Haircut Percentage means, for any item of Eligible Collateral (IM), the percentage specified in accordance with Paragraph 13.
	 */
	BigDecimal getFxHaircutPercentage();
	/**
	 * Percentage value of any additional haircut to be applied to a collateral asset,the percentage value is expressed as the discount haircut to the value of the collateral- as an example a 5% haircut would be expressed as 0.05.
	 */
	BigDecimal getAdditionalHaircutPercentage();
	/**
	 * Paragraph 5. If a party (a &#39;Disputing Party&#39;) disputes the Value of any Posted Credit Support (IM).
	 */
	Money getDisputedCashOrSecurityValue();

	/*********************** Build Methods  ***********************/
	PostedCreditSupportItem build();
	
	PostedCreditSupportItem.PostedCreditSupportItemBuilder toBuilder();
	
	static PostedCreditSupportItem.PostedCreditSupportItemBuilder builder() {
		return new PostedCreditSupportItem.PostedCreditSupportItemBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PostedCreditSupportItem> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PostedCreditSupportItem> getType() {
		return PostedCreditSupportItem.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("cashOrSecurityValue"), processor, Money.class, getCashOrSecurityValue());
		processor.processBasic(path.newSubPath("haircutPercentage"), BigDecimal.class, getHaircutPercentage(), this);
		processor.processBasic(path.newSubPath("fxHaircutPercentage"), BigDecimal.class, getFxHaircutPercentage(), this);
		processor.processBasic(path.newSubPath("additionalHaircutPercentage"), BigDecimal.class, getAdditionalHaircutPercentage(), this);
		processRosetta(path.newSubPath("disputedCashOrSecurityValue"), processor, Money.class, getDisputedCashOrSecurityValue());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PostedCreditSupportItemBuilder extends PostedCreditSupportItem, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateCashOrSecurityValue();
		@Override
		Money.MoneyBuilder getCashOrSecurityValue();
		Money.MoneyBuilder getOrCreateDisputedCashOrSecurityValue();
		@Override
		Money.MoneyBuilder getDisputedCashOrSecurityValue();
		PostedCreditSupportItem.PostedCreditSupportItemBuilder setCashOrSecurityValue(Money cashOrSecurityValue);
		PostedCreditSupportItem.PostedCreditSupportItemBuilder setHaircutPercentage(BigDecimal haircutPercentage);
		PostedCreditSupportItem.PostedCreditSupportItemBuilder setFxHaircutPercentage(BigDecimal fxHaircutPercentage);
		PostedCreditSupportItem.PostedCreditSupportItemBuilder setAdditionalHaircutPercentage(BigDecimal additionalHaircutPercentage);
		PostedCreditSupportItem.PostedCreditSupportItemBuilder setDisputedCashOrSecurityValue(Money disputedCashOrSecurityValue);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("cashOrSecurityValue"), processor, Money.MoneyBuilder.class, getCashOrSecurityValue());
			processor.processBasic(path.newSubPath("haircutPercentage"), BigDecimal.class, getHaircutPercentage(), this);
			processor.processBasic(path.newSubPath("fxHaircutPercentage"), BigDecimal.class, getFxHaircutPercentage(), this);
			processor.processBasic(path.newSubPath("additionalHaircutPercentage"), BigDecimal.class, getAdditionalHaircutPercentage(), this);
			processRosetta(path.newSubPath("disputedCashOrSecurityValue"), processor, Money.MoneyBuilder.class, getDisputedCashOrSecurityValue());
		}
		

		PostedCreditSupportItem.PostedCreditSupportItemBuilder prune();
	}

	/*********************** Immutable Implementation of PostedCreditSupportItem  ***********************/
	class PostedCreditSupportItemImpl implements PostedCreditSupportItem {
		private final Money cashOrSecurityValue;
		private final BigDecimal haircutPercentage;
		private final BigDecimal fxHaircutPercentage;
		private final BigDecimal additionalHaircutPercentage;
		private final Money disputedCashOrSecurityValue;
		
		protected PostedCreditSupportItemImpl(PostedCreditSupportItem.PostedCreditSupportItemBuilder builder) {
			this.cashOrSecurityValue = ofNullable(builder.getCashOrSecurityValue()).map(f->f.build()).orElse(null);
			this.haircutPercentage = builder.getHaircutPercentage();
			this.fxHaircutPercentage = builder.getFxHaircutPercentage();
			this.additionalHaircutPercentage = builder.getAdditionalHaircutPercentage();
			this.disputedCashOrSecurityValue = ofNullable(builder.getDisputedCashOrSecurityValue()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("cashOrSecurityValue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cashOrSecurityValue")
		public Money getCashOrSecurityValue() {
			return cashOrSecurityValue;
		}
		
		@Override
		@RosettaAttribute("haircutPercentage")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("haircutPercentage")
		public BigDecimal getHaircutPercentage() {
			return haircutPercentage;
		}
		
		@Override
		@RosettaAttribute("fxHaircutPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxHaircutPercentage")
		public BigDecimal getFxHaircutPercentage() {
			return fxHaircutPercentage;
		}
		
		@Override
		@RosettaAttribute("additionalHaircutPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalHaircutPercentage")
		public BigDecimal getAdditionalHaircutPercentage() {
			return additionalHaircutPercentage;
		}
		
		@Override
		@RosettaAttribute("disputedCashOrSecurityValue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("disputedCashOrSecurityValue")
		public Money getDisputedCashOrSecurityValue() {
			return disputedCashOrSecurityValue;
		}
		
		@Override
		public PostedCreditSupportItem build() {
			return this;
		}
		
		@Override
		public PostedCreditSupportItem.PostedCreditSupportItemBuilder toBuilder() {
			PostedCreditSupportItem.PostedCreditSupportItemBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PostedCreditSupportItem.PostedCreditSupportItemBuilder builder) {
			ofNullable(getCashOrSecurityValue()).ifPresent(builder::setCashOrSecurityValue);
			ofNullable(getHaircutPercentage()).ifPresent(builder::setHaircutPercentage);
			ofNullable(getFxHaircutPercentage()).ifPresent(builder::setFxHaircutPercentage);
			ofNullable(getAdditionalHaircutPercentage()).ifPresent(builder::setAdditionalHaircutPercentage);
			ofNullable(getDisputedCashOrSecurityValue()).ifPresent(builder::setDisputedCashOrSecurityValue);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PostedCreditSupportItem _that = getType().cast(o);
		
			if (!Objects.equals(cashOrSecurityValue, _that.getCashOrSecurityValue())) return false;
			if (!Objects.equals(haircutPercentage, _that.getHaircutPercentage())) return false;
			if (!Objects.equals(fxHaircutPercentage, _that.getFxHaircutPercentage())) return false;
			if (!Objects.equals(additionalHaircutPercentage, _that.getAdditionalHaircutPercentage())) return false;
			if (!Objects.equals(disputedCashOrSecurityValue, _that.getDisputedCashOrSecurityValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashOrSecurityValue != null ? cashOrSecurityValue.hashCode() : 0);
			_result = 31 * _result + (haircutPercentage != null ? haircutPercentage.hashCode() : 0);
			_result = 31 * _result + (fxHaircutPercentage != null ? fxHaircutPercentage.hashCode() : 0);
			_result = 31 * _result + (additionalHaircutPercentage != null ? additionalHaircutPercentage.hashCode() : 0);
			_result = 31 * _result + (disputedCashOrSecurityValue != null ? disputedCashOrSecurityValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostedCreditSupportItem {" +
				"cashOrSecurityValue=" + this.cashOrSecurityValue + ", " +
				"haircutPercentage=" + this.haircutPercentage + ", " +
				"fxHaircutPercentage=" + this.fxHaircutPercentage + ", " +
				"additionalHaircutPercentage=" + this.additionalHaircutPercentage + ", " +
				"disputedCashOrSecurityValue=" + this.disputedCashOrSecurityValue +
			'}';
		}
	}

	/*********************** Builder Implementation of PostedCreditSupportItem  ***********************/
	class PostedCreditSupportItemBuilderImpl implements PostedCreditSupportItem.PostedCreditSupportItemBuilder {
	
		protected Money.MoneyBuilder cashOrSecurityValue;
		protected BigDecimal haircutPercentage;
		protected BigDecimal fxHaircutPercentage;
		protected BigDecimal additionalHaircutPercentage;
		protected Money.MoneyBuilder disputedCashOrSecurityValue;
		
		@Override
		@RosettaAttribute("cashOrSecurityValue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cashOrSecurityValue")
		public Money.MoneyBuilder getCashOrSecurityValue() {
			return cashOrSecurityValue;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateCashOrSecurityValue() {
			Money.MoneyBuilder result;
			if (cashOrSecurityValue!=null) {
				result = cashOrSecurityValue;
			}
			else {
				result = cashOrSecurityValue = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("haircutPercentage")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("haircutPercentage")
		public BigDecimal getHaircutPercentage() {
			return haircutPercentage;
		}
		
		@Override
		@RosettaAttribute("fxHaircutPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxHaircutPercentage")
		public BigDecimal getFxHaircutPercentage() {
			return fxHaircutPercentage;
		}
		
		@Override
		@RosettaAttribute("additionalHaircutPercentage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalHaircutPercentage")
		public BigDecimal getAdditionalHaircutPercentage() {
			return additionalHaircutPercentage;
		}
		
		@Override
		@RosettaAttribute("disputedCashOrSecurityValue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("disputedCashOrSecurityValue")
		public Money.MoneyBuilder getDisputedCashOrSecurityValue() {
			return disputedCashOrSecurityValue;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateDisputedCashOrSecurityValue() {
			Money.MoneyBuilder result;
			if (disputedCashOrSecurityValue!=null) {
				result = disputedCashOrSecurityValue;
			}
			else {
				result = disputedCashOrSecurityValue = Money.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("cashOrSecurityValue")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("cashOrSecurityValue")
		@Override
		public PostedCreditSupportItem.PostedCreditSupportItemBuilder setCashOrSecurityValue(Money _cashOrSecurityValue) {
			this.cashOrSecurityValue = _cashOrSecurityValue == null ? null : _cashOrSecurityValue.toBuilder();
			return this;
		}
		
		@RosettaAttribute("haircutPercentage")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("haircutPercentage")
		@Override
		public PostedCreditSupportItem.PostedCreditSupportItemBuilder setHaircutPercentage(BigDecimal _haircutPercentage) {
			this.haircutPercentage = _haircutPercentage == null ? null : _haircutPercentage;
			return this;
		}
		
		@RosettaAttribute("fxHaircutPercentage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxHaircutPercentage")
		@Override
		public PostedCreditSupportItem.PostedCreditSupportItemBuilder setFxHaircutPercentage(BigDecimal _fxHaircutPercentage) {
			this.fxHaircutPercentage = _fxHaircutPercentage == null ? null : _fxHaircutPercentage;
			return this;
		}
		
		@RosettaAttribute("additionalHaircutPercentage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalHaircutPercentage")
		@Override
		public PostedCreditSupportItem.PostedCreditSupportItemBuilder setAdditionalHaircutPercentage(BigDecimal _additionalHaircutPercentage) {
			this.additionalHaircutPercentage = _additionalHaircutPercentage == null ? null : _additionalHaircutPercentage;
			return this;
		}
		
		@RosettaAttribute("disputedCashOrSecurityValue")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("disputedCashOrSecurityValue")
		@Override
		public PostedCreditSupportItem.PostedCreditSupportItemBuilder setDisputedCashOrSecurityValue(Money _disputedCashOrSecurityValue) {
			this.disputedCashOrSecurityValue = _disputedCashOrSecurityValue == null ? null : _disputedCashOrSecurityValue.toBuilder();
			return this;
		}
		
		@Override
		public PostedCreditSupportItem build() {
			return new PostedCreditSupportItem.PostedCreditSupportItemImpl(this);
		}
		
		@Override
		public PostedCreditSupportItem.PostedCreditSupportItemBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PostedCreditSupportItem.PostedCreditSupportItemBuilder prune() {
			if (cashOrSecurityValue!=null && !cashOrSecurityValue.prune().hasData()) cashOrSecurityValue = null;
			if (disputedCashOrSecurityValue!=null && !disputedCashOrSecurityValue.prune().hasData()) disputedCashOrSecurityValue = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCashOrSecurityValue()!=null && getCashOrSecurityValue().hasData()) return true;
			if (getHaircutPercentage()!=null) return true;
			if (getFxHaircutPercentage()!=null) return true;
			if (getAdditionalHaircutPercentage()!=null) return true;
			if (getDisputedCashOrSecurityValue()!=null && getDisputedCashOrSecurityValue().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PostedCreditSupportItem.PostedCreditSupportItemBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PostedCreditSupportItem.PostedCreditSupportItemBuilder o = (PostedCreditSupportItem.PostedCreditSupportItemBuilder) other;
			
			merger.mergeRosetta(getCashOrSecurityValue(), o.getCashOrSecurityValue(), this::setCashOrSecurityValue);
			merger.mergeRosetta(getDisputedCashOrSecurityValue(), o.getDisputedCashOrSecurityValue(), this::setDisputedCashOrSecurityValue);
			
			merger.mergeBasic(getHaircutPercentage(), o.getHaircutPercentage(), this::setHaircutPercentage);
			merger.mergeBasic(getFxHaircutPercentage(), o.getFxHaircutPercentage(), this::setFxHaircutPercentage);
			merger.mergeBasic(getAdditionalHaircutPercentage(), o.getAdditionalHaircutPercentage(), this::setAdditionalHaircutPercentage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PostedCreditSupportItem _that = getType().cast(o);
		
			if (!Objects.equals(cashOrSecurityValue, _that.getCashOrSecurityValue())) return false;
			if (!Objects.equals(haircutPercentage, _that.getHaircutPercentage())) return false;
			if (!Objects.equals(fxHaircutPercentage, _that.getFxHaircutPercentage())) return false;
			if (!Objects.equals(additionalHaircutPercentage, _that.getAdditionalHaircutPercentage())) return false;
			if (!Objects.equals(disputedCashOrSecurityValue, _that.getDisputedCashOrSecurityValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cashOrSecurityValue != null ? cashOrSecurityValue.hashCode() : 0);
			_result = 31 * _result + (haircutPercentage != null ? haircutPercentage.hashCode() : 0);
			_result = 31 * _result + (fxHaircutPercentage != null ? fxHaircutPercentage.hashCode() : 0);
			_result = 31 * _result + (additionalHaircutPercentage != null ? additionalHaircutPercentage.hashCode() : 0);
			_result = 31 * _result + (disputedCashOrSecurityValue != null ? disputedCashOrSecurityValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PostedCreditSupportItemBuilder {" +
				"cashOrSecurityValue=" + this.cashOrSecurityValue + ", " +
				"haircutPercentage=" + this.haircutPercentage + ", " +
				"fxHaircutPercentage=" + this.fxHaircutPercentage + ", " +
				"additionalHaircutPercentage=" + this.additionalHaircutPercentage + ", " +
				"disputedCashOrSecurityValue=" + this.disputedCashOrSecurityValue +
			'}';
		}
	}
}
