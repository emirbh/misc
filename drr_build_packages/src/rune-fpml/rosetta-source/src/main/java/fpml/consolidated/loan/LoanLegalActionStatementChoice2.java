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
import fpml.consolidated.loan.meta.LoanLegalActionStatementChoice2Meta;
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
@RosettaDataType(value="LoanLegalActionStatementChoice2", builder=LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2BuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanLegalActionStatementChoice2", model="fpml", builder=LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2BuilderImpl.class, version="2.1.1")
public interface LoanLegalActionStatementChoice2 extends RosettaModelObject {

	LoanLegalActionStatementChoice2Meta metaData = new LoanLegalActionStatementChoice2Meta();

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

	/*********************** Build Methods  ***********************/
	LoanLegalActionStatementChoice2 build();
	
	LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder toBuilder();
	
	static LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder builder() {
		return new LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanLegalActionStatementChoice2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanLegalActionStatementChoice2> getType() {
		return LoanLegalActionStatementChoice2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("letterOfCreditIdentifier"), processor, LoanContractIdentifier.class, getLetterOfCreditIdentifier());
		processRosetta(path.newSubPath("letterOfCreditSummary"), processor, LetterOfCreditSummary.class, getLetterOfCreditSummary());
		processRosetta(path.newSubPath("letterOfCredit"), processor, LetterOfCredit.class, getLetterOfCredit());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanLegalActionStatementChoice2Builder extends LoanLegalActionStatementChoice2, RosettaModelObjectBuilder {
		LoanContractIdentifier.LoanContractIdentifierBuilder getOrCreateLetterOfCreditIdentifier();
		@Override
		LoanContractIdentifier.LoanContractIdentifierBuilder getLetterOfCreditIdentifier();
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder getOrCreateLetterOfCreditSummary();
		@Override
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder getLetterOfCreditSummary();
		LetterOfCredit.LetterOfCreditBuilder getOrCreateLetterOfCredit();
		@Override
		LetterOfCredit.LetterOfCreditBuilder getLetterOfCredit();
		LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder setLetterOfCreditIdentifier(LoanContractIdentifier letterOfCreditIdentifier);
		LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder setLetterOfCreditSummary(LetterOfCreditSummary letterOfCreditSummary);
		LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder setLetterOfCredit(LetterOfCredit letterOfCredit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("letterOfCreditIdentifier"), processor, LoanContractIdentifier.LoanContractIdentifierBuilder.class, getLetterOfCreditIdentifier());
			processRosetta(path.newSubPath("letterOfCreditSummary"), processor, LetterOfCreditSummary.LetterOfCreditSummaryBuilder.class, getLetterOfCreditSummary());
			processRosetta(path.newSubPath("letterOfCredit"), processor, LetterOfCredit.LetterOfCreditBuilder.class, getLetterOfCredit());
		}
		

		LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder prune();
	}

	/*********************** Immutable Implementation of LoanLegalActionStatementChoice2  ***********************/
	class LoanLegalActionStatementChoice2Impl implements LoanLegalActionStatementChoice2 {
		private final LoanContractIdentifier letterOfCreditIdentifier;
		private final LetterOfCreditSummary letterOfCreditSummary;
		private final LetterOfCredit letterOfCredit;
		
		protected LoanLegalActionStatementChoice2Impl(LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder builder) {
			this.letterOfCreditIdentifier = ofNullable(builder.getLetterOfCreditIdentifier()).map(f->f.build()).orElse(null);
			this.letterOfCreditSummary = ofNullable(builder.getLetterOfCreditSummary()).map(f->f.build()).orElse(null);
			this.letterOfCredit = ofNullable(builder.getLetterOfCredit()).map(f->f.build()).orElse(null);
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
		public LoanLegalActionStatementChoice2 build() {
			return this;
		}
		
		@Override
		public LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder toBuilder() {
			LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder builder) {
			ofNullable(getLetterOfCreditIdentifier()).ifPresent(builder::setLetterOfCreditIdentifier);
			ofNullable(getLetterOfCreditSummary()).ifPresent(builder::setLetterOfCreditSummary);
			ofNullable(getLetterOfCredit()).ifPresent(builder::setLetterOfCredit);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalActionStatementChoice2 _that = getType().cast(o);
		
			if (!Objects.equals(letterOfCreditIdentifier, _that.getLetterOfCreditIdentifier())) return false;
			if (!Objects.equals(letterOfCreditSummary, _that.getLetterOfCreditSummary())) return false;
			if (!Objects.equals(letterOfCredit, _that.getLetterOfCredit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (letterOfCreditIdentifier != null ? letterOfCreditIdentifier.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditSummary != null ? letterOfCreditSummary.hashCode() : 0);
			_result = 31 * _result + (letterOfCredit != null ? letterOfCredit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionStatementChoice2 {" +
				"letterOfCreditIdentifier=" + this.letterOfCreditIdentifier + ", " +
				"letterOfCreditSummary=" + this.letterOfCreditSummary + ", " +
				"letterOfCredit=" + this.letterOfCredit +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanLegalActionStatementChoice2  ***********************/
	class LoanLegalActionStatementChoice2BuilderImpl implements LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder {
	
		protected LoanContractIdentifier.LoanContractIdentifierBuilder letterOfCreditIdentifier;
		protected LetterOfCreditSummary.LetterOfCreditSummaryBuilder letterOfCreditSummary;
		protected LetterOfCredit.LetterOfCreditBuilder letterOfCredit;
		
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
		
		@RosettaAttribute("letterOfCreditIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("letterOfCreditIdentifier")
		@Override
		public LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder setLetterOfCreditIdentifier(LoanContractIdentifier _letterOfCreditIdentifier) {
			this.letterOfCreditIdentifier = _letterOfCreditIdentifier == null ? null : _letterOfCreditIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("letterOfCreditSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("letterOfCreditSummary")
		@Override
		public LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder setLetterOfCreditSummary(LetterOfCreditSummary _letterOfCreditSummary) {
			this.letterOfCreditSummary = _letterOfCreditSummary == null ? null : _letterOfCreditSummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("letterOfCredit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("letterOfCredit")
		@Override
		public LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder setLetterOfCredit(LetterOfCredit _letterOfCredit) {
			this.letterOfCredit = _letterOfCredit == null ? null : _letterOfCredit.toBuilder();
			return this;
		}
		
		@Override
		public LoanLegalActionStatementChoice2 build() {
			return new LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Impl(this);
		}
		
		@Override
		public LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder prune() {
			if (letterOfCreditIdentifier!=null && !letterOfCreditIdentifier.prune().hasData()) letterOfCreditIdentifier = null;
			if (letterOfCreditSummary!=null && !letterOfCreditSummary.prune().hasData()) letterOfCreditSummary = null;
			if (letterOfCredit!=null && !letterOfCredit.prune().hasData()) letterOfCredit = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLetterOfCreditIdentifier()!=null && getLetterOfCreditIdentifier().hasData()) return true;
			if (getLetterOfCreditSummary()!=null && getLetterOfCreditSummary().hasData()) return true;
			if (getLetterOfCredit()!=null && getLetterOfCredit().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder o = (LoanLegalActionStatementChoice2.LoanLegalActionStatementChoice2Builder) other;
			
			merger.mergeRosetta(getLetterOfCreditIdentifier(), o.getLetterOfCreditIdentifier(), this::setLetterOfCreditIdentifier);
			merger.mergeRosetta(getLetterOfCreditSummary(), o.getLetterOfCreditSummary(), this::setLetterOfCreditSummary);
			merger.mergeRosetta(getLetterOfCredit(), o.getLetterOfCredit(), this::setLetterOfCredit);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanLegalActionStatementChoice2 _that = getType().cast(o);
		
			if (!Objects.equals(letterOfCreditIdentifier, _that.getLetterOfCreditIdentifier())) return false;
			if (!Objects.equals(letterOfCreditSummary, _that.getLetterOfCreditSummary())) return false;
			if (!Objects.equals(letterOfCredit, _that.getLetterOfCredit())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (letterOfCreditIdentifier != null ? letterOfCreditIdentifier.hashCode() : 0);
			_result = 31 * _result + (letterOfCreditSummary != null ? letterOfCreditSummary.hashCode() : 0);
			_result = 31 * _result + (letterOfCredit != null ? letterOfCredit.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanLegalActionStatementChoice2Builder {" +
				"letterOfCreditIdentifier=" + this.letterOfCreditIdentifier + ", " +
				"letterOfCreditSummary=" + this.letterOfCreditSummary + ", " +
				"letterOfCredit=" + this.letterOfCredit +
			'}';
		}
	}
}
