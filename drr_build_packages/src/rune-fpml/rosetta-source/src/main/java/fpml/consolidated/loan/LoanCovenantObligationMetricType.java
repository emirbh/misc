package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.LoanCovenantObligationMetricTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure used to uniquely identify a loan covenant obligation metric type.
 *
 */
@RosettaDataType(value="LoanCovenantObligationMetricType", builder=LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanCovenantObligationMetricType", model="fpml", builder=LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilderImpl.class, version="2.1.1")
public interface LoanCovenantObligationMetricType extends RosettaModelObject {

	LoanCovenantObligationMetricTypeMeta metaData = new LoanCovenantObligationMetricTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getLoanCovenantObligationMetricTypeScheme();

	/*********************** Build Methods  ***********************/
	LoanCovenantObligationMetricType build();
	
	LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilder toBuilder();
	
	static LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilder builder() {
		return new LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanCovenantObligationMetricType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanCovenantObligationMetricType> getType() {
		return LoanCovenantObligationMetricType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("loanCovenantObligationMetricTypeScheme"), String.class, getLoanCovenantObligationMetricTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanCovenantObligationMetricTypeBuilder extends LoanCovenantObligationMetricType, RosettaModelObjectBuilder {
		LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilder setValue(String value);
		LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilder setLoanCovenantObligationMetricTypeScheme(String loanCovenantObligationMetricTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("loanCovenantObligationMetricTypeScheme"), String.class, getLoanCovenantObligationMetricTypeScheme(), this);
		}
		

		LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilder prune();
	}

	/*********************** Immutable Implementation of LoanCovenantObligationMetricType  ***********************/
	class LoanCovenantObligationMetricTypeImpl implements LoanCovenantObligationMetricType {
		private final String value;
		private final String loanCovenantObligationMetricTypeScheme;
		
		protected LoanCovenantObligationMetricTypeImpl(LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilder builder) {
			this.value = builder.getValue();
			this.loanCovenantObligationMetricTypeScheme = builder.getLoanCovenantObligationMetricTypeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("loanCovenantObligationMetricTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loanCovenantObligationMetricTypeScheme")
		public String getLoanCovenantObligationMetricTypeScheme() {
			return loanCovenantObligationMetricTypeScheme;
		}
		
		@Override
		public LoanCovenantObligationMetricType build() {
			return this;
		}
		
		@Override
		public LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilder toBuilder() {
			LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getLoanCovenantObligationMetricTypeScheme()).ifPresent(builder::setLoanCovenantObligationMetricTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationMetricType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(loanCovenantObligationMetricTypeScheme, _that.getLoanCovenantObligationMetricTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (loanCovenantObligationMetricTypeScheme != null ? loanCovenantObligationMetricTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationMetricType {" +
				"value=" + this.value + ", " +
				"loanCovenantObligationMetricTypeScheme=" + this.loanCovenantObligationMetricTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanCovenantObligationMetricType  ***********************/
	class LoanCovenantObligationMetricTypeBuilderImpl implements LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilder {
	
		protected String value;
		protected String loanCovenantObligationMetricTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("loanCovenantObligationMetricTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loanCovenantObligationMetricTypeScheme")
		public String getLoanCovenantObligationMetricTypeScheme() {
			return loanCovenantObligationMetricTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("loanCovenantObligationMetricTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("loanCovenantObligationMetricTypeScheme")
		@Override
		public LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilder setLoanCovenantObligationMetricTypeScheme(String _loanCovenantObligationMetricTypeScheme) {
			this.loanCovenantObligationMetricTypeScheme = _loanCovenantObligationMetricTypeScheme == null ? null : _loanCovenantObligationMetricTypeScheme;
			return this;
		}
		
		@Override
		public LoanCovenantObligationMetricType build() {
			return new LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeImpl(this);
		}
		
		@Override
		public LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getLoanCovenantObligationMetricTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilder o = (LoanCovenantObligationMetricType.LoanCovenantObligationMetricTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getLoanCovenantObligationMetricTypeScheme(), o.getLoanCovenantObligationMetricTypeScheme(), this::setLoanCovenantObligationMetricTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationMetricType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(loanCovenantObligationMetricTypeScheme, _that.getLoanCovenantObligationMetricTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (loanCovenantObligationMetricTypeScheme != null ? loanCovenantObligationMetricTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationMetricTypeBuilder {" +
				"value=" + this.value + ", " +
				"loanCovenantObligationMetricTypeScheme=" + this.loanCovenantObligationMetricTypeScheme +
			'}';
		}
	}
}
