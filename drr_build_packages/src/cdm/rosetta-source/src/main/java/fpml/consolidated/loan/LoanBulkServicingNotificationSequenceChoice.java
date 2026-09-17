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
import fpml.consolidated.loan.meta.LoanBulkServicingNotificationSequenceChoiceMeta;
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
@RosettaDataType(value="LoanBulkServicingNotificationSequenceChoice", builder=LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanBulkServicingNotificationSequenceChoice", model="fpml", builder=LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilderImpl.class, version="2.1.1")
public interface LoanBulkServicingNotificationSequenceChoice extends RosettaModelObject {

	LoanBulkServicingNotificationSequenceChoiceMeta metaData = new LoanBulkServicingNotificationSequenceChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A letter of credit identifier structure.
	 *
	 */
	LoanContractIdentifier getLetterOfCreditIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A letter of credit summary structure.
	 *
	 */
	LetterOfCreditSummary getLetterOfCreditSummary();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A full letter of credit structure.
	 *
	 */
	LetterOfCredit getLetterOfCredit();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A loan contract identifier structure.
	 *
	 */
	LoanContractIdentifier getContractIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A loan contract summary structure.
	 *
	 */
	LoanContractSummary getContractSummary();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A full loan contract structure.
	 *
	 */
	LoanContract getContract();

	/*********************** Build Methods  ***********************/
	LoanBulkServicingNotificationSequenceChoice build();
	
	LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder toBuilder();
	
	static LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder builder() {
		return new LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanBulkServicingNotificationSequenceChoice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanBulkServicingNotificationSequenceChoice> getType() {
		return LoanBulkServicingNotificationSequenceChoice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("letterOfCreditIdentifier"), processor, LoanContractIdentifier.class, getLetterOfCreditIdentifier());
		processRosetta(path.newSubPath("letterOfCreditSummary"), processor, LetterOfCreditSummary.class, getLetterOfCreditSummary());
		processRosetta(path.newSubPath("letterOfCredit"), processor, LetterOfCredit.class, getLetterOfCredit());
		processRosetta(path.newSubPath("contractIdentifier"), processor, LoanContractIdentifier.class, getContractIdentifier());
		processRosetta(path.newSubPath("contractSummary"), processor, LoanContractSummary.class, getContractSummary());
		processRosetta(path.newSubPath("contract"), processor, LoanContract.class, getContract());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanBulkServicingNotificationSequenceChoiceBuilder extends LoanBulkServicingNotificationSequenceChoice, RosettaModelObjectBuilder {
		LoanContractIdentifier.LoanContractIdentifierBuilder getOrCreateLetterOfCreditIdentifier();
		@Override
		LoanContractIdentifier.LoanContractIdentifierBuilder getLetterOfCreditIdentifier();
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder getOrCreateLetterOfCreditSummary();
		@Override
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder getLetterOfCreditSummary();
		LetterOfCredit.LetterOfCreditBuilder getOrCreateLetterOfCredit();
		@Override
		LetterOfCredit.LetterOfCreditBuilder getLetterOfCredit();
		LoanContractIdentifier.LoanContractIdentifierBuilder getOrCreateContractIdentifier();
		@Override
		LoanContractIdentifier.LoanContractIdentifierBuilder getContractIdentifier();
		LoanContractSummary.LoanContractSummaryBuilder getOrCreateContractSummary();
		@Override
		LoanContractSummary.LoanContractSummaryBuilder getContractSummary();
		LoanContract.LoanContractBuilder getOrCreateContract();
		@Override
		LoanContract.LoanContractBuilder getContract();
		LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder setLetterOfCreditIdentifier(LoanContractIdentifier letterOfCreditIdentifier);
		LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder setLetterOfCreditSummary(LetterOfCreditSummary letterOfCreditSummary);
		LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder setLetterOfCredit(LetterOfCredit letterOfCredit);
		LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder setContractIdentifier(LoanContractIdentifier contractIdentifier);
		LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder setContractSummary(LoanContractSummary contractSummary);
		LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder setContract(LoanContract contract);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("letterOfCreditIdentifier"), processor, LoanContractIdentifier.LoanContractIdentifierBuilder.class, getLetterOfCreditIdentifier());
			processRosetta(path.newSubPath("letterOfCreditSummary"), processor, LetterOfCreditSummary.LetterOfCreditSummaryBuilder.class, getLetterOfCreditSummary());
			processRosetta(path.newSubPath("letterOfCredit"), processor, LetterOfCredit.LetterOfCreditBuilder.class, getLetterOfCredit());
			processRosetta(path.newSubPath("contractIdentifier"), processor, LoanContractIdentifier.LoanContractIdentifierBuilder.class, getContractIdentifier());
			processRosetta(path.newSubPath("contractSummary"), processor, LoanContractSummary.LoanContractSummaryBuilder.class, getContractSummary());
			processRosetta(path.newSubPath("contract"), processor, LoanContract.LoanContractBuilder.class, getContract());
		}
		

		LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of LoanBulkServicingNotificationSequenceChoice  ***********************/
	class LoanBulkServicingNotificationSequenceChoiceImpl implements LoanBulkServicingNotificationSequenceChoice {
		private final LoanContractIdentifier letterOfCreditIdentifier;
		private final LetterOfCreditSummary letterOfCreditSummary;
		private final LetterOfCredit letterOfCredit;
		private final LoanContractIdentifier contractIdentifier;
		private final LoanContractSummary contractSummary;
		private final LoanContract contract;
		
		protected LoanBulkServicingNotificationSequenceChoiceImpl(LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder builder) {
			this.letterOfCreditIdentifier = ofNullable(builder.getLetterOfCreditIdentifier()).map(f->f.build()).orElse(null);
			this.letterOfCreditSummary = ofNullable(builder.getLetterOfCreditSummary()).map(f->f.build()).orElse(null);
			this.letterOfCredit = ofNullable(builder.getLetterOfCredit()).map(f->f.build()).orElse(null);
			this.contractIdentifier = ofNullable(builder.getContractIdentifier()).map(f->f.build()).orElse(null);
			this.contractSummary = ofNullable(builder.getContractSummary()).map(f->f.build()).orElse(null);
			this.contract = ofNullable(builder.getContract()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("letterOfCreditIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("letterOfCreditIdentifier")
		public LoanContractIdentifier getLetterOfCreditIdentifier() {
			return letterOfCreditIdentifier;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("letterOfCreditSummary")
		public LetterOfCreditSummary getLetterOfCreditSummary() {
			return letterOfCreditSummary;
		}
		
		@Override
		@RosettaAttribute("letterOfCredit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("letterOfCredit")
		public LetterOfCredit getLetterOfCredit() {
			return letterOfCredit;
		}
		
		@Override
		@RosettaAttribute("contractIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractIdentifier")
		public LoanContractIdentifier getContractIdentifier() {
			return contractIdentifier;
		}
		
		@Override
		@RosettaAttribute("contractSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractSummary")
		public LoanContractSummary getContractSummary() {
			return contractSummary;
		}
		
		@Override
		@RosettaAttribute("contract")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contract")
		public LoanContract getContract() {
			return contract;
		}
		
		@Override
		public LoanBulkServicingNotificationSequenceChoice build() {
			return this;
		}
		
		@Override
		public LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder toBuilder() {
			LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder builder) {
			ofNullable(getLetterOfCreditIdentifier()).ifPresent(builder::setLetterOfCreditIdentifier);
			ofNullable(getLetterOfCreditSummary()).ifPresent(builder::setLetterOfCreditSummary);
			ofNullable(getLetterOfCredit()).ifPresent(builder::setLetterOfCredit);
			ofNullable(getContractIdentifier()).ifPresent(builder::setContractIdentifier);
			ofNullable(getContractSummary()).ifPresent(builder::setContractSummary);
			ofNullable(getContract()).ifPresent(builder::setContract);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanBulkServicingNotificationSequenceChoice _that = getType().cast(o);
		
			if (!Objects.equals(letterOfCreditIdentifier, _that.getLetterOfCreditIdentifier())) return false;
			if (!Objects.equals(letterOfCreditSummary, _that.getLetterOfCreditSummary())) return false;
			if (!Objects.equals(letterOfCredit, _that.getLetterOfCredit())) return false;
			if (!Objects.equals(contractIdentifier, _that.getContractIdentifier())) return false;
			if (!Objects.equals(contractSummary, _that.getContractSummary())) return false;
			if (!Objects.equals(contract, _that.getContract())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (letterOfCreditIdentifier != null ? letterOfCreditIdentifier.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditSummary != null ? letterOfCreditSummary.hashCode() : 0);
			_result = 31 * _result + (letterOfCredit != null ? letterOfCredit.hashCode() : 0);
			_result = 31 * _result + (contractIdentifier != null ? contractIdentifier.hashCode() : 0);
			_result = 31 * _result + (contractSummary != null ? contractSummary.hashCode() : 0);
			_result = 31 * _result + (contract != null ? contract.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanBulkServicingNotificationSequenceChoice {" +
				"letterOfCreditIdentifier=" + this.letterOfCreditIdentifier + ", " +
				"letterOfCreditSummary=" + this.letterOfCreditSummary + ", " +
				"letterOfCredit=" + this.letterOfCredit + ", " +
				"contractIdentifier=" + this.contractIdentifier + ", " +
				"contractSummary=" + this.contractSummary + ", " +
				"contract=" + this.contract +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanBulkServicingNotificationSequenceChoice  ***********************/
	class LoanBulkServicingNotificationSequenceChoiceBuilderImpl implements LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder {
	
		protected LoanContractIdentifier.LoanContractIdentifierBuilder letterOfCreditIdentifier;
		protected LetterOfCreditSummary.LetterOfCreditSummaryBuilder letterOfCreditSummary;
		protected LetterOfCredit.LetterOfCreditBuilder letterOfCredit;
		protected LoanContractIdentifier.LoanContractIdentifierBuilder contractIdentifier;
		protected LoanContractSummary.LoanContractSummaryBuilder contractSummary;
		protected LoanContract.LoanContractBuilder contract;
		
		@Override
		@RosettaAttribute("letterOfCreditIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("letterOfCreditIdentifier")
		public LoanContractIdentifier.LoanContractIdentifierBuilder getLetterOfCreditIdentifier() {
			return letterOfCreditIdentifier;
		}
		
		@Override
		public LoanContractIdentifier.LoanContractIdentifierBuilder getOrCreateLetterOfCreditIdentifier() {
			LoanContractIdentifier.LoanContractIdentifierBuilder result;
			if (letterOfCreditIdentifier!=null) {
				result = letterOfCreditIdentifier;
			}
			else {
				result = letterOfCreditIdentifier = LoanContractIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("letterOfCreditSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("letterOfCreditSummary")
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder getLetterOfCreditSummary() {
			return letterOfCreditSummary;
		}
		
		@Override
		public LetterOfCreditSummary.LetterOfCreditSummaryBuilder getOrCreateLetterOfCreditSummary() {
			LetterOfCreditSummary.LetterOfCreditSummaryBuilder result;
			if (letterOfCreditSummary!=null) {
				result = letterOfCreditSummary;
			}
			else {
				result = letterOfCreditSummary = LetterOfCreditSummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("letterOfCredit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("letterOfCredit")
		public LetterOfCredit.LetterOfCreditBuilder getLetterOfCredit() {
			return letterOfCredit;
		}
		
		@Override
		public LetterOfCredit.LetterOfCreditBuilder getOrCreateLetterOfCredit() {
			LetterOfCredit.LetterOfCreditBuilder result;
			if (letterOfCredit!=null) {
				result = letterOfCredit;
			}
			else {
				result = letterOfCredit = LetterOfCredit.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("contractIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractIdentifier")
		public LoanContractIdentifier.LoanContractIdentifierBuilder getContractIdentifier() {
			return contractIdentifier;
		}
		
		@Override
		public LoanContractIdentifier.LoanContractIdentifierBuilder getOrCreateContractIdentifier() {
			LoanContractIdentifier.LoanContractIdentifierBuilder result;
			if (contractIdentifier!=null) {
				result = contractIdentifier;
			}
			else {
				result = contractIdentifier = LoanContractIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("contractSummary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractSummary")
		public LoanContractSummary.LoanContractSummaryBuilder getContractSummary() {
			return contractSummary;
		}
		
		@Override
		public LoanContractSummary.LoanContractSummaryBuilder getOrCreateContractSummary() {
			LoanContractSummary.LoanContractSummaryBuilder result;
			if (contractSummary!=null) {
				result = contractSummary;
			}
			else {
				result = contractSummary = LoanContractSummary.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("contract")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contract")
		public LoanContract.LoanContractBuilder getContract() {
			return contract;
		}
		
		@Override
		public LoanContract.LoanContractBuilder getOrCreateContract() {
			LoanContract.LoanContractBuilder result;
			if (contract!=null) {
				result = contract;
			}
			else {
				result = contract = LoanContract.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("letterOfCreditIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("letterOfCreditIdentifier")
		@Override
		public LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder setLetterOfCreditIdentifier(LoanContractIdentifier _letterOfCreditIdentifier) {
			this.letterOfCreditIdentifier = _letterOfCreditIdentifier == null ? null : _letterOfCreditIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("letterOfCreditSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("letterOfCreditSummary")
		@Override
		public LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder setLetterOfCreditSummary(LetterOfCreditSummary _letterOfCreditSummary) {
			this.letterOfCreditSummary = _letterOfCreditSummary == null ? null : _letterOfCreditSummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("letterOfCredit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("letterOfCredit")
		@Override
		public LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder setLetterOfCredit(LetterOfCredit _letterOfCredit) {
			this.letterOfCredit = _letterOfCredit == null ? null : _letterOfCredit.toBuilder();
			return this;
		}
		
		@RosettaAttribute("contractIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contractIdentifier")
		@Override
		public LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder setContractIdentifier(LoanContractIdentifier _contractIdentifier) {
			this.contractIdentifier = _contractIdentifier == null ? null : _contractIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("contractSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contractSummary")
		@Override
		public LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder setContractSummary(LoanContractSummary _contractSummary) {
			this.contractSummary = _contractSummary == null ? null : _contractSummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("contract")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contract")
		@Override
		public LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder setContract(LoanContract _contract) {
			this.contract = _contract == null ? null : _contract.toBuilder();
			return this;
		}
		
		@Override
		public LoanBulkServicingNotificationSequenceChoice build() {
			return new LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceImpl(this);
		}
		
		@Override
		public LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder prune() {
			if (letterOfCreditIdentifier!=null && !letterOfCreditIdentifier.prune().hasData()) letterOfCreditIdentifier = null;
			if (letterOfCreditSummary!=null && !letterOfCreditSummary.prune().hasData()) letterOfCreditSummary = null;
			if (letterOfCredit!=null && !letterOfCredit.prune().hasData()) letterOfCredit = null;
			if (contractIdentifier!=null && !contractIdentifier.prune().hasData()) contractIdentifier = null;
			if (contractSummary!=null && !contractSummary.prune().hasData()) contractSummary = null;
			if (contract!=null && !contract.prune().hasData()) contract = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLetterOfCreditIdentifier()!=null && getLetterOfCreditIdentifier().hasData()) return true;
			if (getLetterOfCreditSummary()!=null && getLetterOfCreditSummary().hasData()) return true;
			if (getLetterOfCredit()!=null && getLetterOfCredit().hasData()) return true;
			if (getContractIdentifier()!=null && getContractIdentifier().hasData()) return true;
			if (getContractSummary()!=null && getContractSummary().hasData()) return true;
			if (getContract()!=null && getContract().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder o = (LoanBulkServicingNotificationSequenceChoice.LoanBulkServicingNotificationSequenceChoiceBuilder) other;
			
			merger.mergeRosetta(getLetterOfCreditIdentifier(), o.getLetterOfCreditIdentifier(), this::setLetterOfCreditIdentifier);
			merger.mergeRosetta(getLetterOfCreditSummary(), o.getLetterOfCreditSummary(), this::setLetterOfCreditSummary);
			merger.mergeRosetta(getLetterOfCredit(), o.getLetterOfCredit(), this::setLetterOfCredit);
			merger.mergeRosetta(getContractIdentifier(), o.getContractIdentifier(), this::setContractIdentifier);
			merger.mergeRosetta(getContractSummary(), o.getContractSummary(), this::setContractSummary);
			merger.mergeRosetta(getContract(), o.getContract(), this::setContract);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanBulkServicingNotificationSequenceChoice _that = getType().cast(o);
		
			if (!Objects.equals(letterOfCreditIdentifier, _that.getLetterOfCreditIdentifier())) return false;
			if (!Objects.equals(letterOfCreditSummary, _that.getLetterOfCreditSummary())) return false;
			if (!Objects.equals(letterOfCredit, _that.getLetterOfCredit())) return false;
			if (!Objects.equals(contractIdentifier, _that.getContractIdentifier())) return false;
			if (!Objects.equals(contractSummary, _that.getContractSummary())) return false;
			if (!Objects.equals(contract, _that.getContract())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (letterOfCreditIdentifier != null ? letterOfCreditIdentifier.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditSummary != null ? letterOfCreditSummary.hashCode() : 0);
			_result = 31 * _result + (letterOfCredit != null ? letterOfCredit.hashCode() : 0);
			_result = 31 * _result + (contractIdentifier != null ? contractIdentifier.hashCode() : 0);
			_result = 31 * _result + (contractSummary != null ? contractSummary.hashCode() : 0);
			_result = 31 * _result + (contract != null ? contract.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanBulkServicingNotificationSequenceChoiceBuilder {" +
				"letterOfCreditIdentifier=" + this.letterOfCreditIdentifier + ", " +
				"letterOfCreditSummary=" + this.letterOfCreditSummary + ", " +
				"letterOfCredit=" + this.letterOfCredit + ", " +
				"contractIdentifier=" + this.contractIdentifier + ", " +
				"contractSummary=" + this.contractSummary + ", " +
				"contract=" + this.contract +
			'}';
		}
	}
}
