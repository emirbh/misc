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
import fpml.consolidated.loan.meta.FacilityNotificationChoice1Meta;
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
@RosettaDataType(value="FacilityNotificationChoice1", builder=FacilityNotificationChoice1.FacilityNotificationChoice1BuilderImpl.class, version="2.1.1")
@RuneDataType(value="FacilityNotificationChoice1", model="fpml", builder=FacilityNotificationChoice1.FacilityNotificationChoice1BuilderImpl.class, version="2.1.1")
public interface FacilityNotificationChoice1 extends RosettaModelObject {

	FacilityNotificationChoice1Meta metaData = new FacilityNotificationChoice1Meta();

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
	FacilityNotificationChoice1 build();
	
	FacilityNotificationChoice1.FacilityNotificationChoice1Builder toBuilder();
	
	static FacilityNotificationChoice1.FacilityNotificationChoice1Builder builder() {
		return new FacilityNotificationChoice1.FacilityNotificationChoice1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FacilityNotificationChoice1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FacilityNotificationChoice1> getType() {
		return FacilityNotificationChoice1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("letterOfCreditIdentifier"), processor, LoanContractIdentifier.class, getLetterOfCreditIdentifier());
		processRosetta(path.newSubPath("letterOfCreditSummary"), processor, LetterOfCreditSummary.class, getLetterOfCreditSummary());
		processRosetta(path.newSubPath("letterOfCredit"), processor, LetterOfCredit.class, getLetterOfCredit());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FacilityNotificationChoice1Builder extends FacilityNotificationChoice1, RosettaModelObjectBuilder {
		LoanContractIdentifier.LoanContractIdentifierBuilder getOrCreateLetterOfCreditIdentifier();
		@Override
		LoanContractIdentifier.LoanContractIdentifierBuilder getLetterOfCreditIdentifier();
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder getOrCreateLetterOfCreditSummary();
		@Override
		LetterOfCreditSummary.LetterOfCreditSummaryBuilder getLetterOfCreditSummary();
		LetterOfCredit.LetterOfCreditBuilder getOrCreateLetterOfCredit();
		@Override
		LetterOfCredit.LetterOfCreditBuilder getLetterOfCredit();
		FacilityNotificationChoice1.FacilityNotificationChoice1Builder setLetterOfCreditIdentifier(LoanContractIdentifier letterOfCreditIdentifier);
		FacilityNotificationChoice1.FacilityNotificationChoice1Builder setLetterOfCreditSummary(LetterOfCreditSummary letterOfCreditSummary);
		FacilityNotificationChoice1.FacilityNotificationChoice1Builder setLetterOfCredit(LetterOfCredit letterOfCredit);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("letterOfCreditIdentifier"), processor, LoanContractIdentifier.LoanContractIdentifierBuilder.class, getLetterOfCreditIdentifier());
			processRosetta(path.newSubPath("letterOfCreditSummary"), processor, LetterOfCreditSummary.LetterOfCreditSummaryBuilder.class, getLetterOfCreditSummary());
			processRosetta(path.newSubPath("letterOfCredit"), processor, LetterOfCredit.LetterOfCreditBuilder.class, getLetterOfCredit());
		}
		

		FacilityNotificationChoice1.FacilityNotificationChoice1Builder prune();
	}

	/*********************** Immutable Implementation of FacilityNotificationChoice1  ***********************/
	class FacilityNotificationChoice1Impl implements FacilityNotificationChoice1 {
		private final LoanContractIdentifier letterOfCreditIdentifier;
		private final LetterOfCreditSummary letterOfCreditSummary;
		private final LetterOfCredit letterOfCredit;
		
		protected FacilityNotificationChoice1Impl(FacilityNotificationChoice1.FacilityNotificationChoice1Builder builder) {
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
		public FacilityNotificationChoice1 build() {
			return this;
		}
		
		@Override
		public FacilityNotificationChoice1.FacilityNotificationChoice1Builder toBuilder() {
			FacilityNotificationChoice1.FacilityNotificationChoice1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FacilityNotificationChoice1.FacilityNotificationChoice1Builder builder) {
			ofNullable(getLetterOfCreditIdentifier()).ifPresent(builder::setLetterOfCreditIdentifier);
			ofNullable(getLetterOfCreditSummary()).ifPresent(builder::setLetterOfCreditSummary);
			ofNullable(getLetterOfCredit()).ifPresent(builder::setLetterOfCredit);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityNotificationChoice1 _that = getType().cast(o);
		
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
			return "FacilityNotificationChoice1 {" +
				"letterOfCreditIdentifier=" + this.letterOfCreditIdentifier + ", " +
				"letterOfCreditSummary=" + this.letterOfCreditSummary + ", " +
				"letterOfCredit=" + this.letterOfCredit +
			'}';
		}
	}

	/*********************** Builder Implementation of FacilityNotificationChoice1  ***********************/
	class FacilityNotificationChoice1BuilderImpl implements FacilityNotificationChoice1.FacilityNotificationChoice1Builder {
	
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
		public FacilityNotificationChoice1.FacilityNotificationChoice1Builder setLetterOfCreditIdentifier(LoanContractIdentifier _letterOfCreditIdentifier) {
			this.letterOfCreditIdentifier = _letterOfCreditIdentifier == null ? null : _letterOfCreditIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("letterOfCreditSummary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("letterOfCreditSummary")
		@Override
		public FacilityNotificationChoice1.FacilityNotificationChoice1Builder setLetterOfCreditSummary(LetterOfCreditSummary _letterOfCreditSummary) {
			this.letterOfCreditSummary = _letterOfCreditSummary == null ? null : _letterOfCreditSummary.toBuilder();
			return this;
		}
		
		@RosettaAttribute("letterOfCredit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("letterOfCredit")
		@Override
		public FacilityNotificationChoice1.FacilityNotificationChoice1Builder setLetterOfCredit(LetterOfCredit _letterOfCredit) {
			this.letterOfCredit = _letterOfCredit == null ? null : _letterOfCredit.toBuilder();
			return this;
		}
		
		@Override
		public FacilityNotificationChoice1 build() {
			return new FacilityNotificationChoice1.FacilityNotificationChoice1Impl(this);
		}
		
		@Override
		public FacilityNotificationChoice1.FacilityNotificationChoice1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FacilityNotificationChoice1.FacilityNotificationChoice1Builder prune() {
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
		public FacilityNotificationChoice1.FacilityNotificationChoice1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FacilityNotificationChoice1.FacilityNotificationChoice1Builder o = (FacilityNotificationChoice1.FacilityNotificationChoice1Builder) other;
			
			merger.mergeRosetta(getLetterOfCreditIdentifier(), o.getLetterOfCreditIdentifier(), this::setLetterOfCreditIdentifier);
			merger.mergeRosetta(getLetterOfCreditSummary(), o.getLetterOfCreditSummary(), this::setLetterOfCreditSummary);
			merger.mergeRosetta(getLetterOfCredit(), o.getLetterOfCredit(), this::setLetterOfCredit);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FacilityNotificationChoice1 _that = getType().cast(o);
		
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
			return "FacilityNotificationChoice1Builder {" +
				"letterOfCreditIdentifier=" + this.letterOfCreditIdentifier + ", " +
				"letterOfCreditSummary=" + this.letterOfCreditSummary + ", " +
				"letterOfCredit=" + this.letterOfCredit +
			'}';
		}
	}
}
