package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.LoanLegalStructureAfterChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="LoanLegalStructureAfterChoice", builder=LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanLegalStructureAfterChoice", model="fpml", builder=LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilderImpl.class, version="2.1.1")
public interface LoanLegalStructureAfterChoice extends RosettaModelObject {

	LoanLegalStructureAfterChoiceMeta metaData = new LoanLegalStructureAfterChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A loan contract reference.
	 *
	 */
	LoanContractReference getContractReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A full letter of credit structure.
	 *
	 */
	LetterOfCreditReference getLetterOfCreditReference();

	/*********************** Build Methods  ***********************/
	LoanLegalStructureAfterChoice build();
	
	LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder toBuilder();
	
	static LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder builder() {
		return new LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanLegalStructureAfterChoice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanLegalStructureAfterChoice> getType() {
		return LoanLegalStructureAfterChoice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("contractReference"), processor, LoanContractReference.class, getContractReference());
		processRosetta(path.newSubPath("letterOfCreditReference"), processor, LetterOfCreditReference.class, getLetterOfCreditReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanLegalStructureAfterChoiceBuilder extends LoanLegalStructureAfterChoice, RosettaModelObjectBuilder {
		LoanContractReference.LoanContractReferenceBuilder getOrCreateContractReference();
		@Override
		LoanContractReference.LoanContractReferenceBuilder getContractReference();
		LetterOfCreditReference.LetterOfCreditReferenceBuilder getOrCreateLetterOfCreditReference();
		@Override
		LetterOfCreditReference.LetterOfCreditReferenceBuilder getLetterOfCreditReference();
		LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder setContractReference(LoanContractReference contractReference);
		LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder setLetterOfCreditReference(LetterOfCreditReference letterOfCreditReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("contractReference"), processor, LoanContractReference.LoanContractReferenceBuilder.class, getContractReference());
			processRosetta(path.newSubPath("letterOfCreditReference"), processor, LetterOfCreditReference.LetterOfCreditReferenceBuilder.class, getLetterOfCreditReference());
		}
		

		LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of LoanLegalStructureAfterChoice  ***********************/
	class LoanLegalStructureAfterChoiceImpl implements LoanLegalStructureAfterChoice {
		private final LoanContractReference contractReference;
		private final LetterOfCreditReference letterOfCreditReference;
		
		protected LoanLegalStructureAfterChoiceImpl(LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder builder) {
			this.contractReference = ofNullable(builder.getContractReference()).map(f->f.build()).orElse(null);
			this.letterOfCreditReference = ofNullable(builder.getLetterOfCreditReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("contractReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractReference")
		public LoanContractReference getContractReference() {
			return contractReference;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("letterOfCreditReference")
		public LetterOfCreditReference getLetterOfCreditReference() {
			return letterOfCreditReference;
		}
		
		@Override
		public LoanLegalStructureAfterChoice build() {
			return this;
		}
		
		@Override
		public LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder toBuilder() {
			LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder builder) {
			ofNullable(getContractReference()).ifPresent(builder::setContractReference);
			ofNullable(getLetterOfCreditReference()).ifPresent(builder::setLetterOfCreditReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalStructureAfterChoice _that = getType().cast(o);
		
			if (!Objects.equals(contractReference, _that.getContractReference())) return false;
			if (!Objects.equals(letterOfCreditReference, _that.getLetterOfCreditReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contractReference != null ? contractReference.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditReference != null ? letterOfCreditReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalStructureAfterChoice {" +
				"contractReference=" + this.contractReference + ", " +
				"letterOfCreditReference=" + this.letterOfCreditReference +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanLegalStructureAfterChoice  ***********************/
	class LoanLegalStructureAfterChoiceBuilderImpl implements LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder {
	
		protected LoanContractReference.LoanContractReferenceBuilder contractReference;
		protected LetterOfCreditReference.LetterOfCreditReferenceBuilder letterOfCreditReference;
		
		@Override
		@RosettaAttribute("contractReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractReference")
		public LoanContractReference.LoanContractReferenceBuilder getContractReference() {
			return contractReference;
		}
		
		@Override
		public LoanContractReference.LoanContractReferenceBuilder getOrCreateContractReference() {
			LoanContractReference.LoanContractReferenceBuilder result;
			if (contractReference!=null) {
				result = contractReference;
			}
			else {
				result = contractReference = LoanContractReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("letterOfCreditReference")
		public LetterOfCreditReference.LetterOfCreditReferenceBuilder getLetterOfCreditReference() {
			return letterOfCreditReference;
		}
		
		@Override
		public LetterOfCreditReference.LetterOfCreditReferenceBuilder getOrCreateLetterOfCreditReference() {
			LetterOfCreditReference.LetterOfCreditReferenceBuilder result;
			if (letterOfCreditReference!=null) {
				result = letterOfCreditReference;
			}
			else {
				result = letterOfCreditReference = LetterOfCreditReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("contractReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contractReference")
		@Override
		public LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder setContractReference(LoanContractReference _contractReference) {
			this.contractReference = _contractReference == null ? null : _contractReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("letterOfCreditReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("letterOfCreditReference")
		@Override
		public LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder setLetterOfCreditReference(LetterOfCreditReference _letterOfCreditReference) {
			this.letterOfCreditReference = _letterOfCreditReference == null ? null : _letterOfCreditReference.toBuilder();
			return this;
		}
		
		@Override
		public LoanLegalStructureAfterChoice build() {
			return new LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceImpl(this);
		}
		
		@Override
		public LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder prune() {
			if (contractReference!=null && !contractReference.prune().hasData()) contractReference = null;
			if (letterOfCreditReference!=null && !letterOfCreditReference.prune().hasData()) letterOfCreditReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getContractReference()!=null && getContractReference().hasData()) return true;
			if (getLetterOfCreditReference()!=null && getLetterOfCreditReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder o = (LoanLegalStructureAfterChoice.LoanLegalStructureAfterChoiceBuilder) other;
			
			merger.mergeRosetta(getContractReference(), o.getContractReference(), this::setContractReference);
			merger.mergeRosetta(getLetterOfCreditReference(), o.getLetterOfCreditReference(), this::setLetterOfCreditReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalStructureAfterChoice _that = getType().cast(o);
		
			if (!Objects.equals(contractReference, _that.getContractReference())) return false;
			if (!Objects.equals(letterOfCreditReference, _that.getLetterOfCreditReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (contractReference != null ? contractReference.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditReference != null ? letterOfCreditReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalStructureAfterChoiceBuilder {" +
				"contractReference=" + this.contractReference + ", " +
				"letterOfCreditReference=" + this.letterOfCreditReference +
			'}';
		}
	}
}
