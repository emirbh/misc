package fpml.consolidated.fx;

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
import fpml.consolidated.fpmlenum.PremiumQuoteBasisEnum;
import fpml.consolidated.fx.meta.PremiumQuoteMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type that describes the option premium as quoted.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that describes the option premium as quoted.
 *
 */
@RosettaDataType(value="PremiumQuote", builder=PremiumQuote.PremiumQuoteBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PremiumQuote", model="fpml", builder=PremiumQuote.PremiumQuoteBuilderImpl.class, version="2.1.1")
public interface PremiumQuote extends RosettaModelObject {

	PremiumQuoteMeta metaData = new PremiumQuoteMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The value of the premium quote. In general this will be either a percentage or an explicit amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The value of the premium quote. In general this will be either a percentage or an explicit amount.
	 *
	 */
	BigDecimal getValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The method by which the option premium was quoted.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The method by which the option premium was quoted.
	 *
	 */
	PremiumQuoteBasisEnum getQuoteBasis();

	/*********************** Build Methods  ***********************/
	PremiumQuote build();
	
	PremiumQuote.PremiumQuoteBuilder toBuilder();
	
	static PremiumQuote.PremiumQuoteBuilder builder() {
		return new PremiumQuote.PremiumQuoteBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PremiumQuote> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PremiumQuote> getType() {
		return PremiumQuote.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
		processor.processBasic(path.newSubPath("quoteBasis"), PremiumQuoteBasisEnum.class, getQuoteBasis(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PremiumQuoteBuilder extends PremiumQuote, RosettaModelObjectBuilder {
		PremiumQuote.PremiumQuoteBuilder setValue(BigDecimal value);
		PremiumQuote.PremiumQuoteBuilder setQuoteBasis(PremiumQuoteBasisEnum quoteBasis);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
			processor.processBasic(path.newSubPath("quoteBasis"), PremiumQuoteBasisEnum.class, getQuoteBasis(), this);
		}
		

		PremiumQuote.PremiumQuoteBuilder prune();
	}

	/*********************** Immutable Implementation of PremiumQuote  ***********************/
	class PremiumQuoteImpl implements PremiumQuote {
		private final BigDecimal value;
		private final PremiumQuoteBasisEnum quoteBasis;
		
		protected PremiumQuoteImpl(PremiumQuote.PremiumQuoteBuilder builder) {
			this.value = builder.getValue();
			this.quoteBasis = builder.getQuoteBasis();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public BigDecimal getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("quoteBasis")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("quoteBasis")
		public PremiumQuoteBasisEnum getQuoteBasis() {
			return quoteBasis;
		}
		
		@Override
		public PremiumQuote build() {
			return this;
		}
		
		@Override
		public PremiumQuote.PremiumQuoteBuilder toBuilder() {
			PremiumQuote.PremiumQuoteBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PremiumQuote.PremiumQuoteBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getQuoteBasis()).ifPresent(builder::setQuoteBasis);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PremiumQuote _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(quoteBasis, _that.getQuoteBasis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (quoteBasis != null ? quoteBasis.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PremiumQuote {" +
				"value=" + this.value + ", " +
				"quoteBasis=" + this.quoteBasis +
			'}';
		}
	}

	/*********************** Builder Implementation of PremiumQuote  ***********************/
	class PremiumQuoteBuilderImpl implements PremiumQuote.PremiumQuoteBuilder {
	
		protected BigDecimal value;
		protected PremiumQuoteBasisEnum quoteBasis;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public BigDecimal getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("quoteBasis")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("quoteBasis")
		public PremiumQuoteBasisEnum getQuoteBasis() {
			return quoteBasis;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public PremiumQuote.PremiumQuoteBuilder setValue(BigDecimal _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("quoteBasis")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("quoteBasis")
		@Override
		public PremiumQuote.PremiumQuoteBuilder setQuoteBasis(PremiumQuoteBasisEnum _quoteBasis) {
			this.quoteBasis = _quoteBasis == null ? null : _quoteBasis;
			return this;
		}
		
		@Override
		public PremiumQuote build() {
			return new PremiumQuote.PremiumQuoteImpl(this);
		}
		
		@Override
		public PremiumQuote.PremiumQuoteBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PremiumQuote.PremiumQuoteBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getQuoteBasis()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PremiumQuote.PremiumQuoteBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PremiumQuote.PremiumQuoteBuilder o = (PremiumQuote.PremiumQuoteBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getQuoteBasis(), o.getQuoteBasis(), this::setQuoteBasis);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PremiumQuote _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(quoteBasis, _that.getQuoteBasis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (quoteBasis != null ? quoteBasis.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PremiumQuoteBuilder {" +
				"value=" + this.value + ", " +
				"quoteBasis=" + this.quoteBasis +
			'}';
		}
	}
}
