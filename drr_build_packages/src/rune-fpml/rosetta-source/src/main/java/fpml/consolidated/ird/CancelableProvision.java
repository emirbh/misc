package fpml.consolidated.ird;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.util.ListEquals;
import fpml.consolidated.ird.meta.CancelableProvisionMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.Exercise;
import fpml.consolidated.shared.ExerciseNotice;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.SimplePayment;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the right of a party to cancel a swap transaction on the specified exercise dates. The provision is for 'walkaway' cancellation (i.e. the fair value of the swap is not paid). A fee payable on exercise can be specified.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the right of a party to cancel a swap transaction on the specified exercise dates. The provision is for 'walkaway' cancellation (i.e. the fair value of the swap is not paid). A fee payable on exercise can be specified.
 *
 */
@RosettaDataType(value="CancelableProvision", builder=CancelableProvision.CancelableProvisionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CancelableProvision", model="fpml", builder=CancelableProvision.CancelableProvisionBuilderImpl.class, version="2.1.1")
public interface CancelableProvision extends RosettaModelObject {

	CancelableProvisionMeta metaData = new CancelableProvisionMeta();

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
	 * Provision The adjusted dates associated with a cancelable provision. These dates have been adjusted for any applicable business day convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The adjusted dates associated with a cancelable provision. These dates have been adjusted for any applicable business day convention.
	 *
	 */
	CancelableProvisionAdjustedDates getCancelableProvisionAdjustedDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Business date convention adjustment to final payment period per leg (swapStream) upon exercise event. The adjustments can be made in-line with leg level BDC's or they can be specified seperately.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Business date convention adjustment to final payment period per leg (swapStream) upon exercise event. The adjustments can be made in-line with leg level BDC's or they can be specified seperately.
	 *
	 */
	List<? extends FinalCalculationPeriodDateAdjustment> getFinalCalculationPeriodDateAdjustment();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An initial fee for the cancelable option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An initial fee for the cancelable option.
	 *
	 */
	SimplePayment getInitialFee();

	/*********************** Build Methods  ***********************/
	CancelableProvision build();
	
	CancelableProvision.CancelableProvisionBuilder toBuilder();
	
	static CancelableProvision.CancelableProvisionBuilder builder() {
		return new CancelableProvision.CancelableProvisionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CancelableProvision> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CancelableProvision> getType() {
		return CancelableProvision.class;
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
		processRosetta(path.newSubPath("cancelableProvisionAdjustedDates"), processor, CancelableProvisionAdjustedDates.class, getCancelableProvisionAdjustedDates());
		processRosetta(path.newSubPath("finalCalculationPeriodDateAdjustment"), processor, FinalCalculationPeriodDateAdjustment.class, getFinalCalculationPeriodDateAdjustment());
		processRosetta(path.newSubPath("initialFee"), processor, SimplePayment.class, getInitialFee());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CancelableProvisionBuilder extends CancelableProvision, RosettaModelObjectBuilder {
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
		CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder getOrCreateCancelableProvisionAdjustedDates();
		@Override
		CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder getCancelableProvisionAdjustedDates();
		FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder getOrCreateFinalCalculationPeriodDateAdjustment(int index);
		@Override
		List<? extends FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder> getFinalCalculationPeriodDateAdjustment();
		SimplePayment.SimplePaymentBuilder getOrCreateInitialFee();
		@Override
		SimplePayment.SimplePaymentBuilder getInitialFee();
		CancelableProvision.CancelableProvisionBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		CancelableProvision.CancelableProvisionBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		CancelableProvision.CancelableProvisionBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		CancelableProvision.CancelableProvisionBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		CancelableProvision.CancelableProvisionBuilder setExercise(Exercise exercise);
		CancelableProvision.CancelableProvisionBuilder setExerciseNotice(ExerciseNotice exerciseNotice);
		CancelableProvision.CancelableProvisionBuilder setFollowUpConfirmation(Boolean followUpConfirmation);
		CancelableProvision.CancelableProvisionBuilder setCancelableProvisionAdjustedDates(CancelableProvisionAdjustedDates cancelableProvisionAdjustedDates);
		CancelableProvision.CancelableProvisionBuilder addFinalCalculationPeriodDateAdjustment(FinalCalculationPeriodDateAdjustment finalCalculationPeriodDateAdjustment);
		CancelableProvision.CancelableProvisionBuilder addFinalCalculationPeriodDateAdjustment(FinalCalculationPeriodDateAdjustment finalCalculationPeriodDateAdjustment, int idx);
		CancelableProvision.CancelableProvisionBuilder addFinalCalculationPeriodDateAdjustment(List<? extends FinalCalculationPeriodDateAdjustment> finalCalculationPeriodDateAdjustment);
		CancelableProvision.CancelableProvisionBuilder setFinalCalculationPeriodDateAdjustment(List<? extends FinalCalculationPeriodDateAdjustment> finalCalculationPeriodDateAdjustment);
		CancelableProvision.CancelableProvisionBuilder setInitialFee(SimplePayment initialFee);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBuyerPartyReference());
			processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getBuyerAccountReference());
			processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSellerPartyReference());
			processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getSellerAccountReference());
			processRosetta(path.newSubPath("exercise"), processor, Exercise.ExerciseBuilder.class, getExercise());
			processRosetta(path.newSubPath("exerciseNotice"), processor, ExerciseNotice.ExerciseNoticeBuilder.class, getExerciseNotice());
			processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
			processRosetta(path.newSubPath("cancelableProvisionAdjustedDates"), processor, CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder.class, getCancelableProvisionAdjustedDates());
			processRosetta(path.newSubPath("finalCalculationPeriodDateAdjustment"), processor, FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder.class, getFinalCalculationPeriodDateAdjustment());
			processRosetta(path.newSubPath("initialFee"), processor, SimplePayment.SimplePaymentBuilder.class, getInitialFee());
		}
		

		CancelableProvision.CancelableProvisionBuilder prune();
	}

	/*********************** Immutable Implementation of CancelableProvision  ***********************/
	class CancelableProvisionImpl implements CancelableProvision {
		private final PartyReference buyerPartyReference;
		private final AccountReference buyerAccountReference;
		private final PartyReference sellerPartyReference;
		private final AccountReference sellerAccountReference;
		private final Exercise exercise;
		private final ExerciseNotice exerciseNotice;
		private final Boolean followUpConfirmation;
		private final CancelableProvisionAdjustedDates cancelableProvisionAdjustedDates;
		private final List<? extends FinalCalculationPeriodDateAdjustment> finalCalculationPeriodDateAdjustment;
		private final SimplePayment initialFee;
		
		protected CancelableProvisionImpl(CancelableProvision.CancelableProvisionBuilder builder) {
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.buyerAccountReference = ofNullable(builder.getBuyerAccountReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerAccountReference = ofNullable(builder.getSellerAccountReference()).map(f->f.build()).orElse(null);
			this.exercise = ofNullable(builder.getExercise()).map(f->f.build()).orElse(null);
			this.exerciseNotice = ofNullable(builder.getExerciseNotice()).map(f->f.build()).orElse(null);
			this.followUpConfirmation = builder.getFollowUpConfirmation();
			this.cancelableProvisionAdjustedDates = ofNullable(builder.getCancelableProvisionAdjustedDates()).map(f->f.build()).orElse(null);
			this.finalCalculationPeriodDateAdjustment = ofNullable(builder.getFinalCalculationPeriodDateAdjustment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.initialFee = ofNullable(builder.getInitialFee()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("cancelableProvisionAdjustedDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cancelableProvisionAdjustedDates")
		public CancelableProvisionAdjustedDates getCancelableProvisionAdjustedDates() {
			return cancelableProvisionAdjustedDates;
		}
		
		@Override
		@RosettaAttribute("finalCalculationPeriodDateAdjustment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("finalCalculationPeriodDateAdjustment")
		public List<? extends FinalCalculationPeriodDateAdjustment> getFinalCalculationPeriodDateAdjustment() {
			return finalCalculationPeriodDateAdjustment;
		}
		
		@Override
		@RosettaAttribute("initialFee")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialFee")
		public SimplePayment getInitialFee() {
			return initialFee;
		}
		
		@Override
		public CancelableProvision build() {
			return this;
		}
		
		@Override
		public CancelableProvision.CancelableProvisionBuilder toBuilder() {
			CancelableProvision.CancelableProvisionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CancelableProvision.CancelableProvisionBuilder builder) {
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getBuyerAccountReference()).ifPresent(builder::setBuyerAccountReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
			ofNullable(getSellerAccountReference()).ifPresent(builder::setSellerAccountReference);
			ofNullable(getExercise()).ifPresent(builder::setExercise);
			ofNullable(getExerciseNotice()).ifPresent(builder::setExerciseNotice);
			ofNullable(getFollowUpConfirmation()).ifPresent(builder::setFollowUpConfirmation);
			ofNullable(getCancelableProvisionAdjustedDates()).ifPresent(builder::setCancelableProvisionAdjustedDates);
			ofNullable(getFinalCalculationPeriodDateAdjustment()).ifPresent(builder::setFinalCalculationPeriodDateAdjustment);
			ofNullable(getInitialFee()).ifPresent(builder::setInitialFee);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CancelableProvision _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!Objects.equals(exerciseNotice, _that.getExerciseNotice())) return false;
			if (!Objects.equals(followUpConfirmation, _that.getFollowUpConfirmation())) return false;
			if (!Objects.equals(cancelableProvisionAdjustedDates, _that.getCancelableProvisionAdjustedDates())) return false;
			if (!ListEquals.listEquals(finalCalculationPeriodDateAdjustment, _that.getFinalCalculationPeriodDateAdjustment())) return false;
			if (!Objects.equals(initialFee, _that.getInitialFee())) return false;
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
			_result = 31 * _result + (cancelableProvisionAdjustedDates != null ? cancelableProvisionAdjustedDates.hashCode() : 0);
			_result = 31 * _result + (finalCalculationPeriodDateAdjustment != null ? finalCalculationPeriodDateAdjustment.hashCode() : 0);
			_result = 31 * _result + (initialFee != null ? initialFee.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CancelableProvision {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"exercise=" + this.exercise + ", " +
				"exerciseNotice=" + this.exerciseNotice + ", " +
				"followUpConfirmation=" + this.followUpConfirmation + ", " +
				"cancelableProvisionAdjustedDates=" + this.cancelableProvisionAdjustedDates + ", " +
				"finalCalculationPeriodDateAdjustment=" + this.finalCalculationPeriodDateAdjustment + ", " +
				"initialFee=" + this.initialFee +
			'}';
		}
	}

	/*********************** Builder Implementation of CancelableProvision  ***********************/
	class CancelableProvisionBuilderImpl implements CancelableProvision.CancelableProvisionBuilder {
	
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected AccountReference.AccountReferenceBuilder buyerAccountReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
		protected AccountReference.AccountReferenceBuilder sellerAccountReference;
		protected Exercise.ExerciseBuilder exercise;
		protected ExerciseNotice.ExerciseNoticeBuilder exerciseNotice;
		protected Boolean followUpConfirmation;
		protected CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder cancelableProvisionAdjustedDates;
		protected List<FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder> finalCalculationPeriodDateAdjustment = new ArrayList<>();
		protected SimplePayment.SimplePaymentBuilder initialFee;
		
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
		@RosettaAttribute("cancelableProvisionAdjustedDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cancelableProvisionAdjustedDates")
		public CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder getCancelableProvisionAdjustedDates() {
			return cancelableProvisionAdjustedDates;
		}
		
		@Override
		public CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder getOrCreateCancelableProvisionAdjustedDates() {
			CancelableProvisionAdjustedDates.CancelableProvisionAdjustedDatesBuilder result;
			if (cancelableProvisionAdjustedDates!=null) {
				result = cancelableProvisionAdjustedDates;
			}
			else {
				result = cancelableProvisionAdjustedDates = CancelableProvisionAdjustedDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("finalCalculationPeriodDateAdjustment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("finalCalculationPeriodDateAdjustment")
		public List<? extends FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder> getFinalCalculationPeriodDateAdjustment() {
			return finalCalculationPeriodDateAdjustment;
		}
		
		@Override
		public FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder getOrCreateFinalCalculationPeriodDateAdjustment(int index) {
			if (finalCalculationPeriodDateAdjustment==null) {
				this.finalCalculationPeriodDateAdjustment = new ArrayList<>();
			}
			return getIndex(finalCalculationPeriodDateAdjustment, index, () -> {
						FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder newFinalCalculationPeriodDateAdjustment = FinalCalculationPeriodDateAdjustment.builder();
						return newFinalCalculationPeriodDateAdjustment;
					});
		}
		
		@Override
		@RosettaAttribute("initialFee")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("initialFee")
		public SimplePayment.SimplePaymentBuilder getInitialFee() {
			return initialFee;
		}
		
		@Override
		public SimplePayment.SimplePaymentBuilder getOrCreateInitialFee() {
			SimplePayment.SimplePaymentBuilder result;
			if (initialFee!=null) {
				result = initialFee;
			}
			else {
				result = initialFee = SimplePayment.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("buyerPartyReference")
		@Override
		public CancelableProvision.CancelableProvisionBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public CancelableProvision.CancelableProvisionBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public CancelableProvision.CancelableProvisionBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public CancelableProvision.CancelableProvisionBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exercise")
		@Override
		public CancelableProvision.CancelableProvisionBuilder setExercise(Exercise _exercise) {
			this.exercise = _exercise == null ? null : _exercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exerciseNotice")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseNotice")
		@Override
		public CancelableProvision.CancelableProvisionBuilder setExerciseNotice(ExerciseNotice _exerciseNotice) {
			this.exerciseNotice = _exerciseNotice == null ? null : _exerciseNotice.toBuilder();
			return this;
		}
		
		@RosettaAttribute("followUpConfirmation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("followUpConfirmation")
		@Override
		public CancelableProvision.CancelableProvisionBuilder setFollowUpConfirmation(Boolean _followUpConfirmation) {
			this.followUpConfirmation = _followUpConfirmation == null ? null : _followUpConfirmation;
			return this;
		}
		
		@RosettaAttribute("cancelableProvisionAdjustedDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cancelableProvisionAdjustedDates")
		@Override
		public CancelableProvision.CancelableProvisionBuilder setCancelableProvisionAdjustedDates(CancelableProvisionAdjustedDates _cancelableProvisionAdjustedDates) {
			this.cancelableProvisionAdjustedDates = _cancelableProvisionAdjustedDates == null ? null : _cancelableProvisionAdjustedDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("finalCalculationPeriodDateAdjustment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("finalCalculationPeriodDateAdjustment")
		@Override
		public CancelableProvision.CancelableProvisionBuilder addFinalCalculationPeriodDateAdjustment(FinalCalculationPeriodDateAdjustment _finalCalculationPeriodDateAdjustment) {
			if (_finalCalculationPeriodDateAdjustment != null) {
				this.finalCalculationPeriodDateAdjustment.add(_finalCalculationPeriodDateAdjustment.toBuilder());
			}
			return this;
		}
		
		@Override
		public CancelableProvision.CancelableProvisionBuilder addFinalCalculationPeriodDateAdjustment(FinalCalculationPeriodDateAdjustment _finalCalculationPeriodDateAdjustment, int idx) {
			getIndex(this.finalCalculationPeriodDateAdjustment, idx, () -> _finalCalculationPeriodDateAdjustment.toBuilder());
			return this;
		}
		
		@Override
		public CancelableProvision.CancelableProvisionBuilder addFinalCalculationPeriodDateAdjustment(List<? extends FinalCalculationPeriodDateAdjustment> finalCalculationPeriodDateAdjustments) {
			if (finalCalculationPeriodDateAdjustments != null) {
				for (final FinalCalculationPeriodDateAdjustment toAdd : finalCalculationPeriodDateAdjustments) {
					this.finalCalculationPeriodDateAdjustment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("finalCalculationPeriodDateAdjustment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("finalCalculationPeriodDateAdjustment")
		@Override
		public CancelableProvision.CancelableProvisionBuilder setFinalCalculationPeriodDateAdjustment(List<? extends FinalCalculationPeriodDateAdjustment> finalCalculationPeriodDateAdjustments) {
			if (finalCalculationPeriodDateAdjustments == null) {
				this.finalCalculationPeriodDateAdjustment = new ArrayList<>();
			} else {
				this.finalCalculationPeriodDateAdjustment = finalCalculationPeriodDateAdjustments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("initialFee")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("initialFee")
		@Override
		public CancelableProvision.CancelableProvisionBuilder setInitialFee(SimplePayment _initialFee) {
			this.initialFee = _initialFee == null ? null : _initialFee.toBuilder();
			return this;
		}
		
		@Override
		public CancelableProvision build() {
			return new CancelableProvision.CancelableProvisionImpl(this);
		}
		
		@Override
		public CancelableProvision.CancelableProvisionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CancelableProvision.CancelableProvisionBuilder prune() {
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (buyerAccountReference!=null && !buyerAccountReference.prune().hasData()) buyerAccountReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			if (sellerAccountReference!=null && !sellerAccountReference.prune().hasData()) sellerAccountReference = null;
			if (exercise!=null && !exercise.prune().hasData()) exercise = null;
			if (exerciseNotice!=null && !exerciseNotice.prune().hasData()) exerciseNotice = null;
			if (cancelableProvisionAdjustedDates!=null && !cancelableProvisionAdjustedDates.prune().hasData()) cancelableProvisionAdjustedDates = null;
			finalCalculationPeriodDateAdjustment = finalCalculationPeriodDateAdjustment.stream().filter(b->b!=null).<FinalCalculationPeriodDateAdjustment.FinalCalculationPeriodDateAdjustmentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (initialFee!=null && !initialFee.prune().hasData()) initialFee = null;
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
			if (getCancelableProvisionAdjustedDates()!=null && getCancelableProvisionAdjustedDates().hasData()) return true;
			if (getFinalCalculationPeriodDateAdjustment()!=null && getFinalCalculationPeriodDateAdjustment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getInitialFee()!=null && getInitialFee().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CancelableProvision.CancelableProvisionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CancelableProvision.CancelableProvisionBuilder o = (CancelableProvision.CancelableProvisionBuilder) other;
			
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getBuyerAccountReference(), o.getBuyerAccountReference(), this::setBuyerAccountReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			merger.mergeRosetta(getSellerAccountReference(), o.getSellerAccountReference(), this::setSellerAccountReference);
			merger.mergeRosetta(getExercise(), o.getExercise(), this::setExercise);
			merger.mergeRosetta(getExerciseNotice(), o.getExerciseNotice(), this::setExerciseNotice);
			merger.mergeRosetta(getCancelableProvisionAdjustedDates(), o.getCancelableProvisionAdjustedDates(), this::setCancelableProvisionAdjustedDates);
			merger.mergeRosetta(getFinalCalculationPeriodDateAdjustment(), o.getFinalCalculationPeriodDateAdjustment(), this::getOrCreateFinalCalculationPeriodDateAdjustment);
			merger.mergeRosetta(getInitialFee(), o.getInitialFee(), this::setInitialFee);
			
			merger.mergeBasic(getFollowUpConfirmation(), o.getFollowUpConfirmation(), this::setFollowUpConfirmation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CancelableProvision _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!Objects.equals(exerciseNotice, _that.getExerciseNotice())) return false;
			if (!Objects.equals(followUpConfirmation, _that.getFollowUpConfirmation())) return false;
			if (!Objects.equals(cancelableProvisionAdjustedDates, _that.getCancelableProvisionAdjustedDates())) return false;
			if (!ListEquals.listEquals(finalCalculationPeriodDateAdjustment, _that.getFinalCalculationPeriodDateAdjustment())) return false;
			if (!Objects.equals(initialFee, _that.getInitialFee())) return false;
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
			_result = 31 * _result + (cancelableProvisionAdjustedDates != null ? cancelableProvisionAdjustedDates.hashCode() : 0);
			_result = 31 * _result + (finalCalculationPeriodDateAdjustment != null ? finalCalculationPeriodDateAdjustment.hashCode() : 0);
			_result = 31 * _result + (initialFee != null ? initialFee.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CancelableProvisionBuilder {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"exercise=" + this.exercise + ", " +
				"exerciseNotice=" + this.exerciseNotice + ", " +
				"followUpConfirmation=" + this.followUpConfirmation + ", " +
				"cancelableProvisionAdjustedDates=" + this.cancelableProvisionAdjustedDates + ", " +
				"finalCalculationPeriodDateAdjustment=" + this.finalCalculationPeriodDateAdjustment + ", " +
				"initialFee=" + this.initialFee +
			'}';
		}
	}
}
