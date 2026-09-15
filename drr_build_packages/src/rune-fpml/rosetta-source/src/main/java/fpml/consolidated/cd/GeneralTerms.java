package fpml.consolidated.cd;

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
import fpml.consolidated.cd.meta.GeneralTermsMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableDate2;
import fpml.consolidated.shared.BusinessDayAdjustments;
import fpml.consolidated.shared.PartyReference;
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
@RosettaDataType(value="GeneralTerms", builder=GeneralTerms.GeneralTermsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="GeneralTerms", model="fpml", builder=GeneralTerms.GeneralTermsBuilderImpl.class, version="2.1.1")
public interface GeneralTerms extends RosettaModelObject {

	GeneralTermsMeta metaData = new GeneralTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The first day of the term of the trade. This day may be subject to adjustment in accordance with a business day convention. ISDA 2003 Term: Effective Date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The first day of the term of the trade. This day may be subject to adjustment in accordance with a business day convention. ISDA 2003 Term: Effective Date.
	 *
	 */
	AdjustableDate2 getEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The scheduled date on which the credit protection will lapse. This day may be subject to adjustment in accordance with a business day convention. ISDA 2003 Term: Scheduled Termination Date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The scheduled date on which the credit protection will lapse. This day may be subject to adjustment in accordance with a business day convention. ISDA 2003 Term: Scheduled Termination Date.
	 *
	 */
	AdjustableDate2 getScheduledTerminationDate();
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
	 * Provision ISDA 2003 Terms: Business Day and Business Day Convention.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision ISDA 2003 Terms: Business Day and Business Day Convention.
	 *
	 */
	BusinessDayAdjustments getDateAdjustments();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element contains all the terms relevant to defining the reference entity and reference obligation(s).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element contains all the terms relevant to defining the reference entity and reference obligation(s).
	 *
	 */
	ReferenceInformation getReferenceInformation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element contains all the terms relevant to defining the Credit DefaultSwap Index.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element contains all the terms relevant to defining the Credit DefaultSwap Index.
	 *
	 */
	IndexReferenceInformation getIndexReferenceInformation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element contains all the terms relevant to defining the Credit Default Swap Basket.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element contains all the terms relevant to defining the Credit Default Swap Basket.
	 *
	 */
	BasketReferenceInformation getBasketReferenceInformation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This element is used for representing information contained in the Additional Terms field of the 2003 Master Credit Derivatives confirm.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This element is used for representing information contained in the Additional Terms field of the 2003 Master Credit Derivatives confirm.
	 *
	 */
	List<? extends AdditionalTerm> getAdditionalTerm();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Value of this element set to 'true' indicates that substitution is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Value of this element set to 'true' indicates that substitution is applicable.
	 *
	 */
	Boolean getSubstitution();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Value of this element set to 'true' indicates that modified equity delivery is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Value of this element set to 'true' indicates that modified equity delivery is applicable.
	 *
	 */
	Boolean getModifiedEquityDelivery();

	/*********************** Build Methods  ***********************/
	GeneralTerms build();
	
	GeneralTerms.GeneralTermsBuilder toBuilder();
	
	static GeneralTerms.GeneralTermsBuilder builder() {
		return new GeneralTerms.GeneralTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GeneralTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends GeneralTerms> getType() {
		return GeneralTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableDate2.class, getEffectiveDate());
		processRosetta(path.newSubPath("scheduledTerminationDate"), processor, AdjustableDate2.class, getScheduledTerminationDate());
		processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.class, getBuyerPartyReference());
		processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.class, getBuyerAccountReference());
		processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.class, getSellerPartyReference());
		processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.class, getSellerAccountReference());
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processRosetta(path.newSubPath("referenceInformation"), processor, ReferenceInformation.class, getReferenceInformation());
		processRosetta(path.newSubPath("indexReferenceInformation"), processor, IndexReferenceInformation.class, getIndexReferenceInformation());
		processRosetta(path.newSubPath("basketReferenceInformation"), processor, BasketReferenceInformation.class, getBasketReferenceInformation());
		processRosetta(path.newSubPath("additionalTerm"), processor, AdditionalTerm.class, getAdditionalTerm());
		processor.processBasic(path.newSubPath("substitution"), Boolean.class, getSubstitution(), this);
		processor.processBasic(path.newSubPath("modifiedEquityDelivery"), Boolean.class, getModifiedEquityDelivery(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GeneralTermsBuilder extends GeneralTerms, RosettaModelObjectBuilder {
		AdjustableDate2.AdjustableDate2Builder getOrCreateEffectiveDate();
		@Override
		AdjustableDate2.AdjustableDate2Builder getEffectiveDate();
		AdjustableDate2.AdjustableDate2Builder getOrCreateScheduledTerminationDate();
		@Override
		AdjustableDate2.AdjustableDate2Builder getScheduledTerminationDate();
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
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments();
		@Override
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments();
		ReferenceInformation.ReferenceInformationBuilder getOrCreateReferenceInformation();
		@Override
		ReferenceInformation.ReferenceInformationBuilder getReferenceInformation();
		IndexReferenceInformation.IndexReferenceInformationBuilder getOrCreateIndexReferenceInformation();
		@Override
		IndexReferenceInformation.IndexReferenceInformationBuilder getIndexReferenceInformation();
		BasketReferenceInformation.BasketReferenceInformationBuilder getOrCreateBasketReferenceInformation();
		@Override
		BasketReferenceInformation.BasketReferenceInformationBuilder getBasketReferenceInformation();
		AdditionalTerm.AdditionalTermBuilder getOrCreateAdditionalTerm(int index);
		@Override
		List<? extends AdditionalTerm.AdditionalTermBuilder> getAdditionalTerm();
		GeneralTerms.GeneralTermsBuilder setEffectiveDate(AdjustableDate2 effectiveDate);
		GeneralTerms.GeneralTermsBuilder setScheduledTerminationDate(AdjustableDate2 scheduledTerminationDate);
		GeneralTerms.GeneralTermsBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		GeneralTerms.GeneralTermsBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		GeneralTerms.GeneralTermsBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		GeneralTerms.GeneralTermsBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		GeneralTerms.GeneralTermsBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		GeneralTerms.GeneralTermsBuilder setReferenceInformation(ReferenceInformation referenceInformation);
		GeneralTerms.GeneralTermsBuilder setIndexReferenceInformation(IndexReferenceInformation indexReferenceInformation);
		GeneralTerms.GeneralTermsBuilder setBasketReferenceInformation(BasketReferenceInformation basketReferenceInformation);
		GeneralTerms.GeneralTermsBuilder addAdditionalTerm(AdditionalTerm additionalTerm);
		GeneralTerms.GeneralTermsBuilder addAdditionalTerm(AdditionalTerm additionalTerm, int idx);
		GeneralTerms.GeneralTermsBuilder addAdditionalTerm(List<? extends AdditionalTerm> additionalTerm);
		GeneralTerms.GeneralTermsBuilder setAdditionalTerm(List<? extends AdditionalTerm> additionalTerm);
		GeneralTerms.GeneralTermsBuilder setSubstitution(Boolean substitution);
		GeneralTerms.GeneralTermsBuilder setModifiedEquityDelivery(Boolean modifiedEquityDelivery);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableDate2.AdjustableDate2Builder.class, getEffectiveDate());
			processRosetta(path.newSubPath("scheduledTerminationDate"), processor, AdjustableDate2.AdjustableDate2Builder.class, getScheduledTerminationDate());
			processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBuyerPartyReference());
			processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getBuyerAccountReference());
			processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSellerPartyReference());
			processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getSellerAccountReference());
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processRosetta(path.newSubPath("referenceInformation"), processor, ReferenceInformation.ReferenceInformationBuilder.class, getReferenceInformation());
			processRosetta(path.newSubPath("indexReferenceInformation"), processor, IndexReferenceInformation.IndexReferenceInformationBuilder.class, getIndexReferenceInformation());
			processRosetta(path.newSubPath("basketReferenceInformation"), processor, BasketReferenceInformation.BasketReferenceInformationBuilder.class, getBasketReferenceInformation());
			processRosetta(path.newSubPath("additionalTerm"), processor, AdditionalTerm.AdditionalTermBuilder.class, getAdditionalTerm());
			processor.processBasic(path.newSubPath("substitution"), Boolean.class, getSubstitution(), this);
			processor.processBasic(path.newSubPath("modifiedEquityDelivery"), Boolean.class, getModifiedEquityDelivery(), this);
		}
		

		GeneralTerms.GeneralTermsBuilder prune();
	}

	/*********************** Immutable Implementation of GeneralTerms  ***********************/
	class GeneralTermsImpl implements GeneralTerms {
		private final AdjustableDate2 effectiveDate;
		private final AdjustableDate2 scheduledTerminationDate;
		private final PartyReference buyerPartyReference;
		private final AccountReference buyerAccountReference;
		private final PartyReference sellerPartyReference;
		private final AccountReference sellerAccountReference;
		private final BusinessDayAdjustments dateAdjustments;
		private final ReferenceInformation referenceInformation;
		private final IndexReferenceInformation indexReferenceInformation;
		private final BasketReferenceInformation basketReferenceInformation;
		private final List<? extends AdditionalTerm> additionalTerm;
		private final Boolean substitution;
		private final Boolean modifiedEquityDelivery;
		
		protected GeneralTermsImpl(GeneralTerms.GeneralTermsBuilder builder) {
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.scheduledTerminationDate = ofNullable(builder.getScheduledTerminationDate()).map(f->f.build()).orElse(null);
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.buyerAccountReference = ofNullable(builder.getBuyerAccountReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerAccountReference = ofNullable(builder.getSellerAccountReference()).map(f->f.build()).orElse(null);
			this.dateAdjustments = ofNullable(builder.getDateAdjustments()).map(f->f.build()).orElse(null);
			this.referenceInformation = ofNullable(builder.getReferenceInformation()).map(f->f.build()).orElse(null);
			this.indexReferenceInformation = ofNullable(builder.getIndexReferenceInformation()).map(f->f.build()).orElse(null);
			this.basketReferenceInformation = ofNullable(builder.getBasketReferenceInformation()).map(f->f.build()).orElse(null);
			this.additionalTerm = ofNullable(builder.getAdditionalTerm()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.substitution = builder.getSubstitution();
			this.modifiedEquityDelivery = builder.getModifiedEquityDelivery();
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public AdjustableDate2 getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("scheduledTerminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("scheduledTerminationDate")
		public AdjustableDate2 getScheduledTerminationDate() {
			return scheduledTerminationDate;
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
		@RosettaAttribute("dateAdjustments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dateAdjustments")
		public BusinessDayAdjustments getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		@RosettaAttribute("referenceInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceInformation")
		public ReferenceInformation getReferenceInformation() {
			return referenceInformation;
		}
		
		@Override
		@RosettaAttribute("indexReferenceInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexReferenceInformation")
		public IndexReferenceInformation getIndexReferenceInformation() {
			return indexReferenceInformation;
		}
		
		@Override
		@RosettaAttribute("basketReferenceInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("basketReferenceInformation")
		public BasketReferenceInformation getBasketReferenceInformation() {
			return basketReferenceInformation;
		}
		
		@Override
		@RosettaAttribute("additionalTerm")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalTerm")
		public List<? extends AdditionalTerm> getAdditionalTerm() {
			return additionalTerm;
		}
		
		@Override
		@RosettaAttribute("substitution")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("substitution")
		public Boolean getSubstitution() {
			return substitution;
		}
		
		@Override
		@RosettaAttribute("modifiedEquityDelivery")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("modifiedEquityDelivery")
		public Boolean getModifiedEquityDelivery() {
			return modifiedEquityDelivery;
		}
		
		@Override
		public GeneralTerms build() {
			return this;
		}
		
		@Override
		public GeneralTerms.GeneralTermsBuilder toBuilder() {
			GeneralTerms.GeneralTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GeneralTerms.GeneralTermsBuilder builder) {
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getScheduledTerminationDate()).ifPresent(builder::setScheduledTerminationDate);
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getBuyerAccountReference()).ifPresent(builder::setBuyerAccountReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
			ofNullable(getSellerAccountReference()).ifPresent(builder::setSellerAccountReference);
			ofNullable(getDateAdjustments()).ifPresent(builder::setDateAdjustments);
			ofNullable(getReferenceInformation()).ifPresent(builder::setReferenceInformation);
			ofNullable(getIndexReferenceInformation()).ifPresent(builder::setIndexReferenceInformation);
			ofNullable(getBasketReferenceInformation()).ifPresent(builder::setBasketReferenceInformation);
			ofNullable(getAdditionalTerm()).ifPresent(builder::setAdditionalTerm);
			ofNullable(getSubstitution()).ifPresent(builder::setSubstitution);
			ofNullable(getModifiedEquityDelivery()).ifPresent(builder::setModifiedEquityDelivery);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GeneralTerms _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(scheduledTerminationDate, _that.getScheduledTerminationDate())) return false;
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(referenceInformation, _that.getReferenceInformation())) return false;
			if (!Objects.equals(indexReferenceInformation, _that.getIndexReferenceInformation())) return false;
			if (!Objects.equals(basketReferenceInformation, _that.getBasketReferenceInformation())) return false;
			if (!ListEquals.listEquals(additionalTerm, _that.getAdditionalTerm())) return false;
			if (!Objects.equals(substitution, _that.getSubstitution())) return false;
			if (!Objects.equals(modifiedEquityDelivery, _that.getModifiedEquityDelivery())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (scheduledTerminationDate != null ? scheduledTerminationDate.hashCode() : 0);
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (referenceInformation != null ? referenceInformation.hashCode() : 0);
			_result = 31 * _result + (indexReferenceInformation != null ? indexReferenceInformation.hashCode() : 0);
			_result = 31 * _result + (basketReferenceInformation != null ? basketReferenceInformation.hashCode() : 0);
			_result = 31 * _result + (additionalTerm != null ? additionalTerm.hashCode() : 0);
			_result = 31 * _result + (substitution != null ? substitution.hashCode() : 0);
			_result = 31 * _result + (modifiedEquityDelivery != null ? modifiedEquityDelivery.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GeneralTerms {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"scheduledTerminationDate=" + this.scheduledTerminationDate + ", " +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"referenceInformation=" + this.referenceInformation + ", " +
				"indexReferenceInformation=" + this.indexReferenceInformation + ", " +
				"basketReferenceInformation=" + this.basketReferenceInformation + ", " +
				"additionalTerm=" + this.additionalTerm + ", " +
				"substitution=" + this.substitution + ", " +
				"modifiedEquityDelivery=" + this.modifiedEquityDelivery +
			'}';
		}
	}

	/*********************** Builder Implementation of GeneralTerms  ***********************/
	class GeneralTermsBuilderImpl implements GeneralTerms.GeneralTermsBuilder {
	
		protected AdjustableDate2.AdjustableDate2Builder effectiveDate;
		protected AdjustableDate2.AdjustableDate2Builder scheduledTerminationDate;
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected AccountReference.AccountReferenceBuilder buyerAccountReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
		protected AccountReference.AccountReferenceBuilder sellerAccountReference;
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder dateAdjustments;
		protected ReferenceInformation.ReferenceInformationBuilder referenceInformation;
		protected IndexReferenceInformation.IndexReferenceInformationBuilder indexReferenceInformation;
		protected BasketReferenceInformation.BasketReferenceInformationBuilder basketReferenceInformation;
		protected List<AdditionalTerm.AdditionalTermBuilder> additionalTerm = new ArrayList<>();
		protected Boolean substitution;
		protected Boolean modifiedEquityDelivery;
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public AdjustableDate2.AdjustableDate2Builder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AdjustableDate2.AdjustableDate2Builder getOrCreateEffectiveDate() {
			AdjustableDate2.AdjustableDate2Builder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AdjustableDate2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("scheduledTerminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("scheduledTerminationDate")
		public AdjustableDate2.AdjustableDate2Builder getScheduledTerminationDate() {
			return scheduledTerminationDate;
		}
		
		@Override
		public AdjustableDate2.AdjustableDate2Builder getOrCreateScheduledTerminationDate() {
			AdjustableDate2.AdjustableDate2Builder result;
			if (scheduledTerminationDate!=null) {
				result = scheduledTerminationDate;
			}
			else {
				result = scheduledTerminationDate = AdjustableDate2.builder();
			}
			
			return result;
		}
		
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
		@RosettaAttribute("dateAdjustments")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dateAdjustments")
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getDateAdjustments() {
			return dateAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateDateAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (dateAdjustments!=null) {
				result = dateAdjustments;
			}
			else {
				result = dateAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("referenceInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("referenceInformation")
		public ReferenceInformation.ReferenceInformationBuilder getReferenceInformation() {
			return referenceInformation;
		}
		
		@Override
		public ReferenceInformation.ReferenceInformationBuilder getOrCreateReferenceInformation() {
			ReferenceInformation.ReferenceInformationBuilder result;
			if (referenceInformation!=null) {
				result = referenceInformation;
			}
			else {
				result = referenceInformation = ReferenceInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexReferenceInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexReferenceInformation")
		public IndexReferenceInformation.IndexReferenceInformationBuilder getIndexReferenceInformation() {
			return indexReferenceInformation;
		}
		
		@Override
		public IndexReferenceInformation.IndexReferenceInformationBuilder getOrCreateIndexReferenceInformation() {
			IndexReferenceInformation.IndexReferenceInformationBuilder result;
			if (indexReferenceInformation!=null) {
				result = indexReferenceInformation;
			}
			else {
				result = indexReferenceInformation = IndexReferenceInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("basketReferenceInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("basketReferenceInformation")
		public BasketReferenceInformation.BasketReferenceInformationBuilder getBasketReferenceInformation() {
			return basketReferenceInformation;
		}
		
		@Override
		public BasketReferenceInformation.BasketReferenceInformationBuilder getOrCreateBasketReferenceInformation() {
			BasketReferenceInformation.BasketReferenceInformationBuilder result;
			if (basketReferenceInformation!=null) {
				result = basketReferenceInformation;
			}
			else {
				result = basketReferenceInformation = BasketReferenceInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("additionalTerm")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("additionalTerm")
		public List<? extends AdditionalTerm.AdditionalTermBuilder> getAdditionalTerm() {
			return additionalTerm;
		}
		
		@Override
		public AdditionalTerm.AdditionalTermBuilder getOrCreateAdditionalTerm(int index) {
			if (additionalTerm==null) {
				this.additionalTerm = new ArrayList<>();
			}
			return getIndex(additionalTerm, index, () -> {
						AdditionalTerm.AdditionalTermBuilder newAdditionalTerm = AdditionalTerm.builder();
						return newAdditionalTerm;
					});
		}
		
		@Override
		@RosettaAttribute("substitution")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("substitution")
		public Boolean getSubstitution() {
			return substitution;
		}
		
		@Override
		@RosettaAttribute("modifiedEquityDelivery")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("modifiedEquityDelivery")
		public Boolean getModifiedEquityDelivery() {
			return modifiedEquityDelivery;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public GeneralTerms.GeneralTermsBuilder setEffectiveDate(AdjustableDate2 _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("scheduledTerminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("scheduledTerminationDate")
		@Override
		public GeneralTerms.GeneralTermsBuilder setScheduledTerminationDate(AdjustableDate2 _scheduledTerminationDate) {
			this.scheduledTerminationDate = _scheduledTerminationDate == null ? null : _scheduledTerminationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("buyerPartyReference")
		@Override
		public GeneralTerms.GeneralTermsBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public GeneralTerms.GeneralTermsBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public GeneralTerms.GeneralTermsBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public GeneralTerms.GeneralTermsBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dateAdjustments")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dateAdjustments")
		@Override
		public GeneralTerms.GeneralTermsBuilder setDateAdjustments(BusinessDayAdjustments _dateAdjustments) {
			this.dateAdjustments = _dateAdjustments == null ? null : _dateAdjustments.toBuilder();
			return this;
		}
		
		@RosettaAttribute("referenceInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("referenceInformation")
		@Override
		public GeneralTerms.GeneralTermsBuilder setReferenceInformation(ReferenceInformation _referenceInformation) {
			this.referenceInformation = _referenceInformation == null ? null : _referenceInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("indexReferenceInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexReferenceInformation")
		@Override
		public GeneralTerms.GeneralTermsBuilder setIndexReferenceInformation(IndexReferenceInformation _indexReferenceInformation) {
			this.indexReferenceInformation = _indexReferenceInformation == null ? null : _indexReferenceInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("basketReferenceInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("basketReferenceInformation")
		@Override
		public GeneralTerms.GeneralTermsBuilder setBasketReferenceInformation(BasketReferenceInformation _basketReferenceInformation) {
			this.basketReferenceInformation = _basketReferenceInformation == null ? null : _basketReferenceInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("additionalTerm")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("additionalTerm")
		@Override
		public GeneralTerms.GeneralTermsBuilder addAdditionalTerm(AdditionalTerm _additionalTerm) {
			if (_additionalTerm != null) {
				this.additionalTerm.add(_additionalTerm.toBuilder());
			}
			return this;
		}
		
		@Override
		public GeneralTerms.GeneralTermsBuilder addAdditionalTerm(AdditionalTerm _additionalTerm, int idx) {
			getIndex(this.additionalTerm, idx, () -> _additionalTerm.toBuilder());
			return this;
		}
		
		@Override
		public GeneralTerms.GeneralTermsBuilder addAdditionalTerm(List<? extends AdditionalTerm> additionalTerms) {
			if (additionalTerms != null) {
				for (final AdditionalTerm toAdd : additionalTerms) {
					this.additionalTerm.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("additionalTerm")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("additionalTerm")
		@Override
		public GeneralTerms.GeneralTermsBuilder setAdditionalTerm(List<? extends AdditionalTerm> additionalTerms) {
			if (additionalTerms == null) {
				this.additionalTerm = new ArrayList<>();
			} else {
				this.additionalTerm = additionalTerms.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("substitution")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("substitution")
		@Override
		public GeneralTerms.GeneralTermsBuilder setSubstitution(Boolean _substitution) {
			this.substitution = _substitution == null ? null : _substitution;
			return this;
		}
		
		@RosettaAttribute("modifiedEquityDelivery")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("modifiedEquityDelivery")
		@Override
		public GeneralTerms.GeneralTermsBuilder setModifiedEquityDelivery(Boolean _modifiedEquityDelivery) {
			this.modifiedEquityDelivery = _modifiedEquityDelivery == null ? null : _modifiedEquityDelivery;
			return this;
		}
		
		@Override
		public GeneralTerms build() {
			return new GeneralTerms.GeneralTermsImpl(this);
		}
		
		@Override
		public GeneralTerms.GeneralTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GeneralTerms.GeneralTermsBuilder prune() {
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (scheduledTerminationDate!=null && !scheduledTerminationDate.prune().hasData()) scheduledTerminationDate = null;
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (buyerAccountReference!=null && !buyerAccountReference.prune().hasData()) buyerAccountReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			if (sellerAccountReference!=null && !sellerAccountReference.prune().hasData()) sellerAccountReference = null;
			if (dateAdjustments!=null && !dateAdjustments.prune().hasData()) dateAdjustments = null;
			if (referenceInformation!=null && !referenceInformation.prune().hasData()) referenceInformation = null;
			if (indexReferenceInformation!=null && !indexReferenceInformation.prune().hasData()) indexReferenceInformation = null;
			if (basketReferenceInformation!=null && !basketReferenceInformation.prune().hasData()) basketReferenceInformation = null;
			additionalTerm = additionalTerm.stream().filter(b->b!=null).<AdditionalTerm.AdditionalTermBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getScheduledTerminationDate()!=null && getScheduledTerminationDate().hasData()) return true;
			if (getBuyerPartyReference()!=null && getBuyerPartyReference().hasData()) return true;
			if (getBuyerAccountReference()!=null && getBuyerAccountReference().hasData()) return true;
			if (getSellerPartyReference()!=null && getSellerPartyReference().hasData()) return true;
			if (getSellerAccountReference()!=null && getSellerAccountReference().hasData()) return true;
			if (getDateAdjustments()!=null && getDateAdjustments().hasData()) return true;
			if (getReferenceInformation()!=null && getReferenceInformation().hasData()) return true;
			if (getIndexReferenceInformation()!=null && getIndexReferenceInformation().hasData()) return true;
			if (getBasketReferenceInformation()!=null && getBasketReferenceInformation().hasData()) return true;
			if (getAdditionalTerm()!=null && getAdditionalTerm().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSubstitution()!=null) return true;
			if (getModifiedEquityDelivery()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GeneralTerms.GeneralTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GeneralTerms.GeneralTermsBuilder o = (GeneralTerms.GeneralTermsBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getScheduledTerminationDate(), o.getScheduledTerminationDate(), this::setScheduledTerminationDate);
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getBuyerAccountReference(), o.getBuyerAccountReference(), this::setBuyerAccountReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			merger.mergeRosetta(getSellerAccountReference(), o.getSellerAccountReference(), this::setSellerAccountReference);
			merger.mergeRosetta(getDateAdjustments(), o.getDateAdjustments(), this::setDateAdjustments);
			merger.mergeRosetta(getReferenceInformation(), o.getReferenceInformation(), this::setReferenceInformation);
			merger.mergeRosetta(getIndexReferenceInformation(), o.getIndexReferenceInformation(), this::setIndexReferenceInformation);
			merger.mergeRosetta(getBasketReferenceInformation(), o.getBasketReferenceInformation(), this::setBasketReferenceInformation);
			merger.mergeRosetta(getAdditionalTerm(), o.getAdditionalTerm(), this::getOrCreateAdditionalTerm);
			
			merger.mergeBasic(getSubstitution(), o.getSubstitution(), this::setSubstitution);
			merger.mergeBasic(getModifiedEquityDelivery(), o.getModifiedEquityDelivery(), this::setModifiedEquityDelivery);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GeneralTerms _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(scheduledTerminationDate, _that.getScheduledTerminationDate())) return false;
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(dateAdjustments, _that.getDateAdjustments())) return false;
			if (!Objects.equals(referenceInformation, _that.getReferenceInformation())) return false;
			if (!Objects.equals(indexReferenceInformation, _that.getIndexReferenceInformation())) return false;
			if (!Objects.equals(basketReferenceInformation, _that.getBasketReferenceInformation())) return false;
			if (!ListEquals.listEquals(additionalTerm, _that.getAdditionalTerm())) return false;
			if (!Objects.equals(substitution, _that.getSubstitution())) return false;
			if (!Objects.equals(modifiedEquityDelivery, _that.getModifiedEquityDelivery())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (scheduledTerminationDate != null ? scheduledTerminationDate.hashCode() : 0);
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (dateAdjustments != null ? dateAdjustments.hashCode() : 0);
			_result = 31 * _result + (referenceInformation != null ? referenceInformation.hashCode() : 0);
			_result = 31 * _result + (indexReferenceInformation != null ? indexReferenceInformation.hashCode() : 0);
			_result = 31 * _result + (basketReferenceInformation != null ? basketReferenceInformation.hashCode() : 0);
			_result = 31 * _result + (additionalTerm != null ? additionalTerm.hashCode() : 0);
			_result = 31 * _result + (substitution != null ? substitution.hashCode() : 0);
			_result = 31 * _result + (modifiedEquityDelivery != null ? modifiedEquityDelivery.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GeneralTermsBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"scheduledTerminationDate=" + this.scheduledTerminationDate + ", " +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"dateAdjustments=" + this.dateAdjustments + ", " +
				"referenceInformation=" + this.referenceInformation + ", " +
				"indexReferenceInformation=" + this.indexReferenceInformation + ", " +
				"basketReferenceInformation=" + this.basketReferenceInformation + ", " +
				"additionalTerm=" + this.additionalTerm + ", " +
				"substitution=" + this.substitution + ", " +
				"modifiedEquityDelivery=" + this.modifiedEquityDelivery +
			'}';
		}
	}
}
