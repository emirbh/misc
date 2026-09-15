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
import fpml.consolidated.loan.meta.LoanLegalActionApprovalStatusTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure used to identify a legal action approval status type, based on a scheme.
 *
 */
@RosettaDataType(value="LoanLegalActionApprovalStatusType", builder=LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanLegalActionApprovalStatusType", model="fpml", builder=LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilderImpl.class, version="2.1.1")
public interface LoanLegalActionApprovalStatusType extends RosettaModelObject {

	LoanLegalActionApprovalStatusTypeMeta metaData = new LoanLegalActionApprovalStatusTypeMeta();

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
	String getLoanLegalActionApprovalStatusTypeScheme();

	/*********************** Build Methods  ***********************/
	LoanLegalActionApprovalStatusType build();
	
	LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilder toBuilder();
	
	static LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilder builder() {
		return new LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanLegalActionApprovalStatusType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanLegalActionApprovalStatusType> getType() {
		return LoanLegalActionApprovalStatusType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("loanLegalActionApprovalStatusTypeScheme"), String.class, getLoanLegalActionApprovalStatusTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanLegalActionApprovalStatusTypeBuilder extends LoanLegalActionApprovalStatusType, RosettaModelObjectBuilder {
		LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilder setValue(String value);
		LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilder setLoanLegalActionApprovalStatusTypeScheme(String loanLegalActionApprovalStatusTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("loanLegalActionApprovalStatusTypeScheme"), String.class, getLoanLegalActionApprovalStatusTypeScheme(), this);
		}
		

		LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilder prune();
	}

	/*********************** Immutable Implementation of LoanLegalActionApprovalStatusType  ***********************/
	class LoanLegalActionApprovalStatusTypeImpl implements LoanLegalActionApprovalStatusType {
		private final String value;
		private final String loanLegalActionApprovalStatusTypeScheme;
		
		protected LoanLegalActionApprovalStatusTypeImpl(LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilder builder) {
			this.value = builder.getValue();
			this.loanLegalActionApprovalStatusTypeScheme = builder.getLoanLegalActionApprovalStatusTypeScheme();
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
		@RosettaAttribute("loanLegalActionApprovalStatusTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loanLegalActionApprovalStatusTypeScheme")
		public String getLoanLegalActionApprovalStatusTypeScheme() {
			return loanLegalActionApprovalStatusTypeScheme;
		}
		
		@Override
		public LoanLegalActionApprovalStatusType build() {
			return this;
		}
		
		@Override
		public LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilder toBuilder() {
			LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getLoanLegalActionApprovalStatusTypeScheme()).ifPresent(builder::setLoanLegalActionApprovalStatusTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalActionApprovalStatusType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(loanLegalActionApprovalStatusTypeScheme, _that.getLoanLegalActionApprovalStatusTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (loanLegalActionApprovalStatusTypeScheme != null ? loanLegalActionApprovalStatusTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionApprovalStatusType {" +
				"value=" + this.value + ", " +
				"loanLegalActionApprovalStatusTypeScheme=" + this.loanLegalActionApprovalStatusTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanLegalActionApprovalStatusType  ***********************/
	class LoanLegalActionApprovalStatusTypeBuilderImpl implements LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilder {
	
		protected String value;
		protected String loanLegalActionApprovalStatusTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("loanLegalActionApprovalStatusTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("loanLegalActionApprovalStatusTypeScheme")
		public String getLoanLegalActionApprovalStatusTypeScheme() {
			return loanLegalActionApprovalStatusTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("loanLegalActionApprovalStatusTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("loanLegalActionApprovalStatusTypeScheme")
		@Override
		public LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilder setLoanLegalActionApprovalStatusTypeScheme(String _loanLegalActionApprovalStatusTypeScheme) {
			this.loanLegalActionApprovalStatusTypeScheme = _loanLegalActionApprovalStatusTypeScheme == null ? null : _loanLegalActionApprovalStatusTypeScheme;
			return this;
		}
		
		@Override
		public LoanLegalActionApprovalStatusType build() {
			return new LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeImpl(this);
		}
		
		@Override
		public LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getLoanLegalActionApprovalStatusTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilder o = (LoanLegalActionApprovalStatusType.LoanLegalActionApprovalStatusTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getLoanLegalActionApprovalStatusTypeScheme(), o.getLoanLegalActionApprovalStatusTypeScheme(), this::setLoanLegalActionApprovalStatusTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalActionApprovalStatusType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(loanLegalActionApprovalStatusTypeScheme, _that.getLoanLegalActionApprovalStatusTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (loanLegalActionApprovalStatusTypeScheme != null ? loanLegalActionApprovalStatusTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionApprovalStatusTypeBuilder {" +
				"value=" + this.value + ", " +
				"loanLegalActionApprovalStatusTypeScheme=" + this.loanLegalActionApprovalStatusTypeScheme +
			'}';
		}
	}
}
