package fpml.consolidated.ird;

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
import fpml.consolidated.ird.meta.ExtendibleProvisionMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.Exercise;
import fpml.consolidated.shared.ExerciseNotice;
import fpml.consolidated.shared.PartyReference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining an option to extend an existing swap transaction on the specified exercise dates for a term ending on the specified new termination date.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining an option to extend an existing swap transaction on the specified exercise dates for a term ending on the specified new termination date.
 *
 */
@RosettaDataType(value="ExtendibleProvision", builder=ExtendibleProvision.ExtendibleProvisionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ExtendibleProvision", model="fpml", builder=ExtendibleProvision.ExtendibleProvisionBuilderImpl.class, version="2.1.1")
public interface ExtendibleProvision extends RosettaModelObject {

	ExtendibleProvisionMeta metaData = new ExtendibleProvisionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party that buys this instrument, ie. pays for this instrument and receives the rights defined by it. See 2000 ISDA definitions Article 11.1 (b). In the case of FRAs this the fixed rate payer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that buys this instrument, ie. pays for this instrument and receives the rights defined by it. See 2000 ISDA definitions Article 11.1 (b). In the case of FRAs this the fixed rate payer.
	 *
	 */
	PartyReference getBuyerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account that buys this instrument.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account that buys this instrument.
	 *
	 */
	AccountReference getBuyerAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party that sells ("writes") this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. See 2000 ISDA definitions Article 11.1 (a). In the case of FRAs this is the floating rate payer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that sells ("writes") this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. See 2000 ISDA definitions Article 11.1 (a). In the case of FRAs this is the floating rate payer.
	 *
	 */
	PartyReference getSellerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account that sells this instrument.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account that sells this instrument.
	 *
	 */
	AccountReference getSellerAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	Exercise getExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Definition of the party to whom notice of exercise should be given.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Definition of the party to whom notice of exercise should be given.
	 *
	 */
	ExerciseNotice getExerciseNotice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A flag to indicate whether follow-up confirmation of exercise (written or electronic) is required following telephonic notice by the buyer to the seller or seller's agent.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A flag to indicate whether follow-up confirmation of exercise (written or electronic) is required following telephonic notice by the buyer to the seller or seller's agent.
	 *
	 */
	Boolean getFollowUpConfirmation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The adjusted dates associated with an extendible provision. These dates have been adjusted for any applicable business day convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The adjusted dates associated with an extendible provision. These dates have been adjusted for any applicable business day convention.
	 *
	 */
	ExtendibleProvisionAdjustedDates getExtendibleProvisionAdjustedDates();

	/*********************** Build Methods  ***********************/
	ExtendibleProvision build();
	
	ExtendibleProvision.ExtendibleProvisionBuilder toBuilder();
	
	static ExtendibleProvision.ExtendibleProvisionBuilder builder() {
		return new ExtendibleProvision.ExtendibleProvisionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExtendibleProvision> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExtendibleProvision> getType() {
		return ExtendibleProvision.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.class, getBuyerPartyReference());
		processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.class, getBuyerAccountReference());
		processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.class, getSellerPartyReference());
		processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.class, getSellerAccountReference());
		processRosetta(path.newSubPath("exercise"), processor, Exercise.class, getExercise());
		processRosetta(path.newSubPath("exerciseNotice"), processor, ExerciseNotice.class, getExerciseNotice());
		processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
		processRosetta(path.newSubPath("extendibleProvisionAdjustedDates"), processor, ExtendibleProvisionAdjustedDates.class, getExtendibleProvisionAdjustedDates());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExtendibleProvisionBuilder extends ExtendibleProvision, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getBuyerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateBuyerAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getBuyerAccountReference();
		PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getSellerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateSellerAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getSellerAccountReference();
		Exercise.ExerciseBuilder getOrCreateExercise();
		@Override
		Exercise.ExerciseBuilder getExercise();
		ExerciseNotice.ExerciseNoticeBuilder getOrCreateExerciseNotice();
		@Override
		ExerciseNotice.ExerciseNoticeBuilder getExerciseNotice();
		ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder getOrCreateExtendibleProvisionAdjustedDates();
		@Override
		ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder getExtendibleProvisionAdjustedDates();
		ExtendibleProvision.ExtendibleProvisionBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		ExtendibleProvision.ExtendibleProvisionBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		ExtendibleProvision.ExtendibleProvisionBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		ExtendibleProvision.ExtendibleProvisionBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		ExtendibleProvision.ExtendibleProvisionBuilder setExercise(Exercise exercise);
		ExtendibleProvision.ExtendibleProvisionBuilder setExerciseNotice(ExerciseNotice exerciseNotice);
		ExtendibleProvision.ExtendibleProvisionBuilder setFollowUpConfirmation(Boolean followUpConfirmation);
		ExtendibleProvision.ExtendibleProvisionBuilder setExtendibleProvisionAdjustedDates(ExtendibleProvisionAdjustedDates extendibleProvisionAdjustedDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBuyerPartyReference());
			processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getBuyerAccountReference());
			processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSellerPartyReference());
			processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getSellerAccountReference());
			processRosetta(path.newSubPath("exercise"), processor, Exercise.ExerciseBuilder.class, getExercise());
			processRosetta(path.newSubPath("exerciseNotice"), processor, ExerciseNotice.ExerciseNoticeBuilder.class, getExerciseNotice());
			processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
			processRosetta(path.newSubPath("extendibleProvisionAdjustedDates"), processor, ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder.class, getExtendibleProvisionAdjustedDates());
		}
		

		ExtendibleProvision.ExtendibleProvisionBuilder prune();
	}

	/*********************** Immutable Implementation of ExtendibleProvision  ***********************/
	class ExtendibleProvisionImpl implements ExtendibleProvision {
		private final PartyReference buyerPartyReference;
		private final AccountReference buyerAccountReference;
		private final PartyReference sellerPartyReference;
		private final AccountReference sellerAccountReference;
		private final Exercise exercise;
		private final ExerciseNotice exerciseNotice;
		private final Boolean followUpConfirmation;
		private final ExtendibleProvisionAdjustedDates extendibleProvisionAdjustedDates;
		
		protected ExtendibleProvisionImpl(ExtendibleProvision.ExtendibleProvisionBuilder builder) {
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.buyerAccountReference = ofNullable(builder.getBuyerAccountReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerAccountReference = ofNullable(builder.getSellerAccountReference()).map(f->f.build()).orElse(null);
			this.exercise = ofNullable(builder.getExercise()).map(f->f.build()).orElse(null);
			this.exerciseNotice = ofNullable(builder.getExerciseNotice()).map(f->f.build()).orElse(null);
			this.followUpConfirmation = builder.getFollowUpConfirmation();
			this.extendibleProvisionAdjustedDates = ofNullable(builder.getExtendibleProvisionAdjustedDates()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("buyerPartyReference")
		public PartyReference getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerAccountReference")
		public AccountReference getBuyerAccountReference() {
			return buyerAccountReference;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		public PartyReference getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerAccountReference")
		public AccountReference getSellerAccountReference() {
			return sellerAccountReference;
		}
		
		@Override
		@RosettaAttribute("exercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exercise")
		public Exercise getExercise() {
			return exercise;
		}
		
		@Override
		@RosettaAttribute("exerciseNotice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseNotice")
		public ExerciseNotice getExerciseNotice() {
			return exerciseNotice;
		}
		
		@Override
		@RosettaAttribute("followUpConfirmation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("followUpConfirmation")
		public Boolean getFollowUpConfirmation() {
			return followUpConfirmation;
		}
		
		@Override
		@RosettaAttribute("extendibleProvisionAdjustedDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("extendibleProvisionAdjustedDates")
		public ExtendibleProvisionAdjustedDates getExtendibleProvisionAdjustedDates() {
			return extendibleProvisionAdjustedDates;
		}
		
		@Override
		public ExtendibleProvision build() {
			return this;
		}
		
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder toBuilder() {
			ExtendibleProvision.ExtendibleProvisionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExtendibleProvision.ExtendibleProvisionBuilder builder) {
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getBuyerAccountReference()).ifPresent(builder::setBuyerAccountReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
			ofNullable(getSellerAccountReference()).ifPresent(builder::setSellerAccountReference);
			ofNullable(getExercise()).ifPresent(builder::setExercise);
			ofNullable(getExerciseNotice()).ifPresent(builder::setExerciseNotice);
			ofNullable(getFollowUpConfirmation()).ifPresent(builder::setFollowUpConfirmation);
			ofNullable(getExtendibleProvisionAdjustedDates()).ifPresent(builder::setExtendibleProvisionAdjustedDates);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExtendibleProvision _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!Objects.equals(exerciseNotice, _that.getExerciseNotice())) return false;
			if (!Objects.equals(followUpConfirmation, _that.getFollowUpConfirmation())) return false;
			if (!Objects.equals(extendibleProvisionAdjustedDates, _that.getExtendibleProvisionAdjustedDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (exerciseNotice != null ? exerciseNotice.hashCode() : 0);
			_result = 31 * _result + (followUpConfirmation != null ? followUpConfirmation.hashCode() : 0);
			_result = 31 * _result + (extendibleProvisionAdjustedDates != null ? extendibleProvisionAdjustedDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExtendibleProvision {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"exercise=" + this.exercise + ", " +
				"exerciseNotice=" + this.exerciseNotice + ", " +
				"followUpConfirmation=" + this.followUpConfirmation + ", " +
				"extendibleProvisionAdjustedDates=" + this.extendibleProvisionAdjustedDates +
			'}';
		}
	}

	/*********************** Builder Implementation of ExtendibleProvision  ***********************/
	class ExtendibleProvisionBuilderImpl implements ExtendibleProvision.ExtendibleProvisionBuilder {
	
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected AccountReference.AccountReferenceBuilder buyerAccountReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
		protected AccountReference.AccountReferenceBuilder sellerAccountReference;
		protected Exercise.ExerciseBuilder exercise;
		protected ExerciseNotice.ExerciseNoticeBuilder exerciseNotice;
		protected Boolean followUpConfirmation;
		protected ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder extendibleProvisionAdjustedDates;
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("buyerPartyReference")
		public PartyReference.PartyReferenceBuilder getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (buyerPartyReference!=null) {
				result = buyerPartyReference;
			}
			else {
				result = buyerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerAccountReference")
		public AccountReference.AccountReferenceBuilder getBuyerAccountReference() {
			return buyerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateBuyerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (buyerAccountReference!=null) {
				result = buyerAccountReference;
			}
			else {
				result = buyerAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		public PartyReference.PartyReferenceBuilder getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (sellerPartyReference!=null) {
				result = sellerPartyReference;
			}
			else {
				result = sellerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerAccountReference")
		public AccountReference.AccountReferenceBuilder getSellerAccountReference() {
			return sellerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateSellerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (sellerAccountReference!=null) {
				result = sellerAccountReference;
			}
			else {
				result = sellerAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exercise")
		public Exercise.ExerciseBuilder getExercise() {
			return exercise;
		}
		
		@Override
		public Exercise.ExerciseBuilder getOrCreateExercise() {
			Exercise.ExerciseBuilder result;
			if (exercise!=null) {
				result = exercise;
			}
			else {
				result = exercise = Exercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseNotice")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseNotice")
		public ExerciseNotice.ExerciseNoticeBuilder getExerciseNotice() {
			return exerciseNotice;
		}
		
		@Override
		public ExerciseNotice.ExerciseNoticeBuilder getOrCreateExerciseNotice() {
			ExerciseNotice.ExerciseNoticeBuilder result;
			if (exerciseNotice!=null) {
				result = exerciseNotice;
			}
			else {
				result = exerciseNotice = ExerciseNotice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("followUpConfirmation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("followUpConfirmation")
		public Boolean getFollowUpConfirmation() {
			return followUpConfirmation;
		}
		
		@Override
		@RosettaAttribute("extendibleProvisionAdjustedDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("extendibleProvisionAdjustedDates")
		public ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder getExtendibleProvisionAdjustedDates() {
			return extendibleProvisionAdjustedDates;
		}
		
		@Override
		public ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder getOrCreateExtendibleProvisionAdjustedDates() {
			ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder result;
			if (extendibleProvisionAdjustedDates!=null) {
				result = extendibleProvisionAdjustedDates;
			}
			else {
				result = extendibleProvisionAdjustedDates = ExtendibleProvisionAdjustedDates.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("buyerPartyReference")
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exercise")
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder setExercise(Exercise _exercise) {
			this.exercise = _exercise == null ? null : _exercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exerciseNotice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseNotice")
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder setExerciseNotice(ExerciseNotice _exerciseNotice) {
			this.exerciseNotice = _exerciseNotice == null ? null : _exerciseNotice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("followUpConfirmation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("followUpConfirmation")
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder setFollowUpConfirmation(Boolean _followUpConfirmation) {
			this.followUpConfirmation = _followUpConfirmation == null ? null : _followUpConfirmation;
			return this;
		}
		
		@RosettaAttribute("extendibleProvisionAdjustedDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("extendibleProvisionAdjustedDates")
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder setExtendibleProvisionAdjustedDates(ExtendibleProvisionAdjustedDates _extendibleProvisionAdjustedDates) {
			this.extendibleProvisionAdjustedDates = _extendibleProvisionAdjustedDates == null ? null : _extendibleProvisionAdjustedDates.toBuilder();
			return this;
		}
		
		@Override
		public ExtendibleProvision build() {
			return new ExtendibleProvision.ExtendibleProvisionImpl(this);
		}
		
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder prune() {
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (buyerAccountReference!=null && !buyerAccountReference.prune().hasData()) buyerAccountReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			if (sellerAccountReference!=null && !sellerAccountReference.prune().hasData()) sellerAccountReference = null;
			if (exercise!=null && !exercise.prune().hasData()) exercise = null;
			if (exerciseNotice!=null && !exerciseNotice.prune().hasData()) exerciseNotice = null;
			if (extendibleProvisionAdjustedDates!=null && !extendibleProvisionAdjustedDates.prune().hasData()) extendibleProvisionAdjustedDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBuyerPartyReference()!=null && getBuyerPartyReference().hasData()) return true;
			if (getBuyerAccountReference()!=null && getBuyerAccountReference().hasData()) return true;
			if (getSellerPartyReference()!=null && getSellerPartyReference().hasData()) return true;
			if (getSellerAccountReference()!=null && getSellerAccountReference().hasData()) return true;
			if (getExercise()!=null && getExercise().hasData()) return true;
			if (getExerciseNotice()!=null && getExerciseNotice().hasData()) return true;
			if (getFollowUpConfirmation()!=null) return true;
			if (getExtendibleProvisionAdjustedDates()!=null && getExtendibleProvisionAdjustedDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExtendibleProvision.ExtendibleProvisionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExtendibleProvision.ExtendibleProvisionBuilder o = (ExtendibleProvision.ExtendibleProvisionBuilder) other;
			
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getBuyerAccountReference(), o.getBuyerAccountReference(), this::setBuyerAccountReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			merger.mergeRosetta(getSellerAccountReference(), o.getSellerAccountReference(), this::setSellerAccountReference);
			merger.mergeRosetta(getExercise(), o.getExercise(), this::setExercise);
			merger.mergeRosetta(getExerciseNotice(), o.getExerciseNotice(), this::setExerciseNotice);
			merger.mergeRosetta(getExtendibleProvisionAdjustedDates(), o.getExtendibleProvisionAdjustedDates(), this::setExtendibleProvisionAdjustedDates);
			
			merger.mergeBasic(getFollowUpConfirmation(), o.getFollowUpConfirmation(), this::setFollowUpConfirmation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExtendibleProvision _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!Objects.equals(exerciseNotice, _that.getExerciseNotice())) return false;
			if (!Objects.equals(followUpConfirmation, _that.getFollowUpConfirmation())) return false;
			if (!Objects.equals(extendibleProvisionAdjustedDates, _that.getExtendibleProvisionAdjustedDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (exerciseNotice != null ? exerciseNotice.hashCode() : 0);
			_result = 31 * _result + (followUpConfirmation != null ? followUpConfirmation.hashCode() : 0);
			_result = 31 * _result + (extendibleProvisionAdjustedDates != null ? extendibleProvisionAdjustedDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExtendibleProvisionBuilder {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"exercise=" + this.exercise + ", " +
				"exerciseNotice=" + this.exerciseNotice + ", " +
				"followUpConfirmation=" + this.followUpConfirmation + ", " +
				"extendibleProvisionAdjustedDates=" + this.extendibleProvisionAdjustedDates +
			'}';
		}
	}
}
