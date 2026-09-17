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
import fpml.consolidated.loan.meta.LoanCovenantObligationTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure used to uniquely identify a loan covenant obligation type.
 *
 */
@RosettaDataType(value="LoanCovenantObligationType", builder=LoanCovenantObligationType.LoanCovenantObligationTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanCovenantObligationType", model="fpml", builder=LoanCovenantObligationType.LoanCovenantObligationTypeBuilderImpl.class, version="2.1.1")
public interface LoanCovenantObligationType extends RosettaModelObject {

	LoanCovenantObligationTypeMeta metaData = new LoanCovenantObligationTypeMeta();

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
	String getLoanCovenantObligationTypeScheme();

	/*********************** Build Methods  ***********************/
	LoanCovenantObligationType build();
	
	LoanCovenantObligationType.LoanCovenantObligationTypeBuilder toBuilder();
	
	static LoanCovenantObligationType.LoanCovenantObligationTypeBuilder builder() {
		return new LoanCovenantObligationType.LoanCovenantObligationTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanCovenantObligationType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanCovenantObligationType> getType() {
		return LoanCovenantObligationType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("loanCovenantObligationTypeScheme"), String.class, getLoanCovenantObligationTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanCovenantObligationTypeBuilder extends LoanCovenantObligationType, RosettaModelObjectBuilder {
		LoanCovenantObligationType.LoanCovenantObligationTypeBuilder setValue(String value);
		LoanCovenantObligationType.LoanCovenantObligationTypeBuilder setLoanCovenantObligationTypeScheme(String loanCovenantObligationTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("loanCovenantObligationTypeScheme"), String.class, getLoanCovenantObligationTypeScheme(), this);
		}
		

		LoanCovenantObligationType.LoanCovenantObligationTypeBuilder prune();
	}

	/*********************** Immutable Implementation of LoanCovenantObligationType  ***********************/
	class LoanCovenantObligationTypeImpl implements LoanCovenantObligationType {
		private final String value;
		private final String loanCovenantObligationTypeScheme;
		
		protected LoanCovenantObligationTypeImpl(LoanCovenantObligationType.LoanCovenantObligationTypeBuilder builder) {
			this.value = builder.getValue();
			this.loanCovenantObligationTypeScheme = builder.getLoanCovenantObligationTypeScheme();
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
		@RosettaAttribute("loanCovenantObligationTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loanCovenantObligationTypeScheme")
		public String getLoanCovenantObligationTypeScheme() {
			return loanCovenantObligationTypeScheme;
		}
		
		@Override
		public LoanCovenantObligationType build() {
			return this;
		}
		
		@Override
		public LoanCovenantObligationType.LoanCovenantObligationTypeBuilder toBuilder() {
			LoanCovenantObligationType.LoanCovenantObligationTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanCovenantObligationType.LoanCovenantObligationTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getLoanCovenantObligationTypeScheme()).ifPresent(builder::setLoanCovenantObligationTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(loanCovenantObligationTypeScheme, _that.getLoanCovenantObligationTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (loanCovenantObligationTypeScheme != null ? loanCovenantObligationTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationType {" +
				"value=" + this.value + ", " +
				"loanCovenantObligationTypeScheme=" + this.loanCovenantObligationTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanCovenantObligationType  ***********************/
	class LoanCovenantObligationTypeBuilderImpl implements LoanCovenantObligationType.LoanCovenantObligationTypeBuilder {
	
		protected String value;
		protected String loanCovenantObligationTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("loanCovenantObligationTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loanCovenantObligationTypeScheme")
		public String getLoanCovenantObligationTypeScheme() {
			return loanCovenantObligationTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public LoanCovenantObligationType.LoanCovenantObligationTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("loanCovenantObligationTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("loanCovenantObligationTypeScheme")
		@Override
		public LoanCovenantObligationType.LoanCovenantObligationTypeBuilder setLoanCovenantObligationTypeScheme(String _loanCovenantObligationTypeScheme) {
			this.loanCovenantObligationTypeScheme = _loanCovenantObligationTypeScheme == null ? null : _loanCovenantObligationTypeScheme;
			return this;
		}
		
		@Override
		public LoanCovenantObligationType build() {
			return new LoanCovenantObligationType.LoanCovenantObligationTypeImpl(this);
		}
		
		@Override
		public LoanCovenantObligationType.LoanCovenantObligationTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationType.LoanCovenantObligationTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getLoanCovenantObligationTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanCovenantObligationType.LoanCovenantObligationTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanCovenantObligationType.LoanCovenantObligationTypeBuilder o = (LoanCovenantObligationType.LoanCovenantObligationTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getLoanCovenantObligationTypeScheme(), o.getLoanCovenantObligationTypeScheme(), this::setLoanCovenantObligationTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanCovenantObligationType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(loanCovenantObligationTypeScheme, _that.getLoanCovenantObligationTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (loanCovenantObligationTypeScheme != null ? loanCovenantObligationTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanCovenantObligationTypeBuilder {" +
				"value=" + this.value + ", " +
				"loanCovenantObligationTypeScheme=" + this.loanCovenantObligationTypeScheme +
			'}';
		}
	}
}
