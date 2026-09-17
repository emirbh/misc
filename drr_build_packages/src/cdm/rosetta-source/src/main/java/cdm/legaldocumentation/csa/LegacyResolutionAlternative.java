package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.LegacyResolutionAlternativeMeta;
import cdm.observable.asset.Money;
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
 * Alternative procedures to those in the pre-print for resolving collateral related disputes.
 * @version 6.23.0
 */
@RosettaDataType(value="LegacyResolutionAlternative", builder=LegacyResolutionAlternative.LegacyResolutionAlternativeBuilderImpl.class, version="6.23.0")
@RuneDataType(value="LegacyResolutionAlternative", model="cdm", builder=LegacyResolutionAlternative.LegacyResolutionAlternativeBuilderImpl.class, version="6.23.0")
public interface LegacyResolutionAlternative extends RosettaModelObject {

	LegacyResolutionAlternativeMeta metaData = new LegacyResolutionAlternativeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Details of the alternative dispute resolution procedure (if any).
	 */
	LegacyResolutionAlternativeEnum getResolutionAlternative();
	/**
	 * The maximum amount to which the difference between the calculations by the valuation agent and disputing party can be split, where Split the Difference is elected.
	 */
	Money getAmount();
	/**
	 * The additional language that might be specified by the parties to the legal agreement.
	 */
	String getAdditionalLanguage();

	/*********************** Build Methods  ***********************/
	LegacyResolutionAlternative build();
	
	LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder toBuilder();
	
	static LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder builder() {
		return new LegacyResolutionAlternative.LegacyResolutionAlternativeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegacyResolutionAlternative> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LegacyResolutionAlternative> getType() {
		return LegacyResolutionAlternative.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("resolutionAlternative"), LegacyResolutionAlternativeEnum.class, getResolutionAlternative(), this);
		processRosetta(path.newSubPath("amount"), processor, Money.class, getAmount());
		processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegacyResolutionAlternativeBuilder extends LegacyResolutionAlternative, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateAmount();
		@Override
		Money.MoneyBuilder getAmount();
		LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder setResolutionAlternative(LegacyResolutionAlternativeEnum resolutionAlternative);
		LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder setAmount(Money amount);
		LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder setAdditionalLanguage(String additionalLanguage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("resolutionAlternative"), LegacyResolutionAlternativeEnum.class, getResolutionAlternative(), this);
			processRosetta(path.newSubPath("amount"), processor, Money.MoneyBuilder.class, getAmount());
			processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
		}
		

		LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder prune();
	}

	/*********************** Immutable Implementation of LegacyResolutionAlternative  ***********************/
	class LegacyResolutionAlternativeImpl implements LegacyResolutionAlternative {
		private final LegacyResolutionAlternativeEnum resolutionAlternative;
		private final Money amount;
		private final String additionalLanguage;
		
		protected LegacyResolutionAlternativeImpl(LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder builder) {
			this.resolutionAlternative = builder.getResolutionAlternative();
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.additionalLanguage = builder.getAdditionalLanguage();
		}
		
		@Override
		@RosettaAttribute("resolutionAlternative")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("resolutionAlternative")
		public LegacyResolutionAlternativeEnum getResolutionAlternative() {
			return resolutionAlternative;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amount")
		public Money getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@Override
		public LegacyResolutionAlternative build() {
			return this;
		}
		
		@Override
		public LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder toBuilder() {
			LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder builder) {
			ofNullable(getResolutionAlternative()).ifPresent(builder::setResolutionAlternative);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getAdditionalLanguage()).ifPresent(builder::setAdditionalLanguage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegacyResolutionAlternative _that = getType().cast(o);
		
			if (!Objects.equals(resolutionAlternative, _that.getResolutionAlternative())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (resolutionAlternative != null ? resolutionAlternative.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyResolutionAlternative {" +
				"resolutionAlternative=" + this.resolutionAlternative + ", " +
				"amount=" + this.amount + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}

	/*********************** Builder Implementation of LegacyResolutionAlternative  ***********************/
	class LegacyResolutionAlternativeBuilderImpl implements LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder {
	
		protected LegacyResolutionAlternativeEnum resolutionAlternative;
		protected Money.MoneyBuilder amount;
		protected String additionalLanguage;
		
		@Override
		@RosettaAttribute("resolutionAlternative")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("resolutionAlternative")
		public LegacyResolutionAlternativeEnum getResolutionAlternative() {
			return resolutionAlternative;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amount")
		public Money.MoneyBuilder getAmount() {
			return amount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateAmount() {
			Money.MoneyBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@RosettaAttribute("resolutionAlternative")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("resolutionAlternative")
		@Override
		public LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder setResolutionAlternative(LegacyResolutionAlternativeEnum _resolutionAlternative) {
			this.resolutionAlternative = _resolutionAlternative == null ? null : _resolutionAlternative;
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amount")
		@Override
		public LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder setAmount(Money _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalLanguage")
		@Override
		public LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder setAdditionalLanguage(String _additionalLanguage) {
			this.additionalLanguage = _additionalLanguage == null ? null : _additionalLanguage;
			return this;
		}
		
		@Override
		public LegacyResolutionAlternative build() {
			return new LegacyResolutionAlternative.LegacyResolutionAlternativeImpl(this);
		}
		
		@Override
		public LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder prune() {
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getResolutionAlternative()!=null) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getAdditionalLanguage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder o = (LegacyResolutionAlternative.LegacyResolutionAlternativeBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			merger.mergeBasic(getResolutionAlternative(), o.getResolutionAlternative(), this::setResolutionAlternative);
			merger.mergeBasic(getAdditionalLanguage(), o.getAdditionalLanguage(), this::setAdditionalLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegacyResolutionAlternative _that = getType().cast(o);
		
			if (!Objects.equals(resolutionAlternative, _that.getResolutionAlternative())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (resolutionAlternative != null ? resolutionAlternative.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyResolutionAlternativeBuilder {" +
				"resolutionAlternative=" + this.resolutionAlternative + ", " +
				"amount=" + this.amount + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}
}
