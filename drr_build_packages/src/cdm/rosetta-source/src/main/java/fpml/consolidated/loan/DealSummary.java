package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.DealSummaryMeta;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.InstrumentId;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
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
 * version "confirmation-5.13"
 *
 * Provision A short form of a deal.
 *
 */
@RosettaDataType(value="DealSummary", builder=DealSummary.DealSummaryBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DealSummary", model="fpml", builder=DealSummary.DealSummaryBuilderImpl.class, version="2.1.1")
public interface DealSummary extends DealIdentifier {

	DealSummaryMeta metaData = new DealSummaryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A party reference to the (main) issuer of the deal.
	 *
	 */
	PartyReference getIssuerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Party references to the guarantors associated with the (main) issuer of the deal.
	 *
	 */
	List<? extends PartyReference> getGuarantorPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A party reference to the agent bank associated with the deal.
	 *
	 */
	PartyReference getAgentPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A party reference to the lead syndication bank of the deal.
	 *
	 */
	PartyReference getSyndicationLeadPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Party references to the syndication co-lead banks of the deal.
	 *
	 */
	List<? extends PartyReference> getSyndicationCoLeadPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The credit agreement date is also known as the 'closing date' (the date on which the agreement was signed). Funding of the facilities occurs either on or after (in the case of a Delayed Draw) the Credit Agreement date.
	 *
	 */
	ZonedDateTime getCreditAgreementDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Deal denomination currency.
	 *
	 */
	Currency getCurrency();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Original deal amount.
	 *
	 */
	NonNegativeMoney getIssuedAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Current deal amount.
	 *
	 */
	MoneyWithParticipantShare getCurrentDealAmount();

	/*********************** Build Methods  ***********************/
	DealSummary build();
	
	DealSummary.DealSummaryBuilder toBuilder();
	
	static DealSummary.DealSummaryBuilder builder() {
		return new DealSummary.DealSummaryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DealSummary> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DealSummary> getType() {
		return DealSummary.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.class, getInstrumentId());
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("issuerPartyReference"), processor, PartyReference.class, getIssuerPartyReference());
		processRosetta(path.newSubPath("guarantorPartyReference"), processor, PartyReference.class, getGuarantorPartyReference());
		processRosetta(path.newSubPath("agentPartyReference"), processor, PartyReference.class, getAgentPartyReference());
		processRosetta(path.newSubPath("syndicationLeadPartyReference"), processor, PartyReference.class, getSyndicationLeadPartyReference());
		processRosetta(path.newSubPath("syndicationCoLeadPartyReference"), processor, PartyReference.class, getSyndicationCoLeadPartyReference());
		processor.processBasic(path.newSubPath("creditAgreementDate"), ZonedDateTime.class, getCreditAgreementDate(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processRosetta(path.newSubPath("issuedAmount"), processor, NonNegativeMoney.class, getIssuedAmount());
		processRosetta(path.newSubPath("currentDealAmount"), processor, MoneyWithParticipantShare.class, getCurrentDealAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DealSummaryBuilder extends DealSummary, DealIdentifier.DealIdentifierBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateIssuerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getIssuerPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateGuarantorPartyReference(int index);
		@Override
		List<? extends PartyReference.PartyReferenceBuilder> getGuarantorPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateAgentPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getAgentPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateSyndicationLeadPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getSyndicationLeadPartyReference();
		PartyReference.PartyReferenceBuilder getOrCreateSyndicationCoLeadPartyReference(int index);
		@Override
		List<? extends PartyReference.PartyReferenceBuilder> getSyndicationCoLeadPartyReference();
		Currency.CurrencyBuilder getOrCreateCurrency();
		@Override
		Currency.CurrencyBuilder getCurrency();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateIssuedAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getIssuedAmount();
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateCurrentDealAmount();
		@Override
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getCurrentDealAmount();
		@Override
		DealSummary.DealSummaryBuilder setId(String id);
		@Override
		DealSummary.DealSummaryBuilder setPartyReference(PartyReference partyReference);
		@Override
		DealSummary.DealSummaryBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		DealSummary.DealSummaryBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		DealSummary.DealSummaryBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		DealSummary.DealSummaryBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		DealSummary.DealSummaryBuilder setDescription(String description);
		DealSummary.DealSummaryBuilder setIssuerPartyReference(PartyReference issuerPartyReference);
		DealSummary.DealSummaryBuilder addGuarantorPartyReference(PartyReference guarantorPartyReference);
		DealSummary.DealSummaryBuilder addGuarantorPartyReference(PartyReference guarantorPartyReference, int idx);
		DealSummary.DealSummaryBuilder addGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReference);
		DealSummary.DealSummaryBuilder setGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReference);
		DealSummary.DealSummaryBuilder setAgentPartyReference(PartyReference agentPartyReference);
		DealSummary.DealSummaryBuilder setSyndicationLeadPartyReference(PartyReference syndicationLeadPartyReference);
		DealSummary.DealSummaryBuilder addSyndicationCoLeadPartyReference(PartyReference syndicationCoLeadPartyReference);
		DealSummary.DealSummaryBuilder addSyndicationCoLeadPartyReference(PartyReference syndicationCoLeadPartyReference, int idx);
		DealSummary.DealSummaryBuilder addSyndicationCoLeadPartyReference(List<? extends PartyReference> syndicationCoLeadPartyReference);
		DealSummary.DealSummaryBuilder setSyndicationCoLeadPartyReference(List<? extends PartyReference> syndicationCoLeadPartyReference);
		DealSummary.DealSummaryBuilder setCreditAgreementDate(ZonedDateTime creditAgreementDate);
		DealSummary.DealSummaryBuilder setCurrency(Currency currency);
		DealSummary.DealSummaryBuilder setIssuedAmount(NonNegativeMoney issuedAmount);
		DealSummary.DealSummaryBuilder setCurrentDealAmount(MoneyWithParticipantShare currentDealAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("instrumentId"), processor, InstrumentId.InstrumentIdBuilder.class, getInstrumentId());
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("issuerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getIssuerPartyReference());
			processRosetta(path.newSubPath("guarantorPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getGuarantorPartyReference());
			processRosetta(path.newSubPath("agentPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getAgentPartyReference());
			processRosetta(path.newSubPath("syndicationLeadPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSyndicationLeadPartyReference());
			processRosetta(path.newSubPath("syndicationCoLeadPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSyndicationCoLeadPartyReference());
			processor.processBasic(path.newSubPath("creditAgreementDate"), ZonedDateTime.class, getCreditAgreementDate(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("issuedAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getIssuedAmount());
			processRosetta(path.newSubPath("currentDealAmount"), processor, MoneyWithParticipantShare.MoneyWithParticipantShareBuilder.class, getCurrentDealAmount());
		}
		

		DealSummary.DealSummaryBuilder prune();
	}

	/*********************** Immutable Implementation of DealSummary  ***********************/
	class DealSummaryImpl extends DealIdentifier.DealIdentifierImpl implements DealSummary {
		private final PartyReference issuerPartyReference;
		private final List<? extends PartyReference> guarantorPartyReference;
		private final PartyReference agentPartyReference;
		private final PartyReference syndicationLeadPartyReference;
		private final List<? extends PartyReference> syndicationCoLeadPartyReference;
		private final ZonedDateTime creditAgreementDate;
		private final Currency currency;
		private final NonNegativeMoney issuedAmount;
		private final MoneyWithParticipantShare currentDealAmount;
		
		protected DealSummaryImpl(DealSummary.DealSummaryBuilder builder) {
			super(builder);
			this.issuerPartyReference = ofNullable(builder.getIssuerPartyReference()).map(f->f.build()).orElse(null);
			this.guarantorPartyReference = ofNullable(builder.getGuarantorPartyReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.agentPartyReference = ofNullable(builder.getAgentPartyReference()).map(f->f.build()).orElse(null);
			this.syndicationLeadPartyReference = ofNullable(builder.getSyndicationLeadPartyReference()).map(f->f.build()).orElse(null);
			this.syndicationCoLeadPartyReference = ofNullable(builder.getSyndicationCoLeadPartyReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.creditAgreementDate = builder.getCreditAgreementDate();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.issuedAmount = ofNullable(builder.getIssuedAmount()).map(f->f.build()).orElse(null);
			this.currentDealAmount = ofNullable(builder.getCurrentDealAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("issuerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("issuerPartyReference")
		public PartyReference getIssuerPartyReference() {
			return issuerPartyReference;
		}
		
		@Override
		@RosettaAttribute("guarantorPartyReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("guarantorPartyReference")
		public List<? extends PartyReference> getGuarantorPartyReference() {
			return guarantorPartyReference;
		}
		
		@Override
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("agentPartyReference")
		public PartyReference getAgentPartyReference() {
			return agentPartyReference;
		}
		
		@Override
		@RosettaAttribute("syndicationLeadPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("syndicationLeadPartyReference")
		public PartyReference getSyndicationLeadPartyReference() {
			return syndicationLeadPartyReference;
		}
		
		@Override
		@RosettaAttribute("syndicationCoLeadPartyReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("syndicationCoLeadPartyReference")
		public List<? extends PartyReference> getSyndicationCoLeadPartyReference() {
			return syndicationCoLeadPartyReference;
		}
		
		@Override
		@RosettaAttribute("creditAgreementDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("creditAgreementDate")
		public ZonedDateTime getCreditAgreementDate() {
			return creditAgreementDate;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("issuedAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("issuedAmount")
		public NonNegativeMoney getIssuedAmount() {
			return issuedAmount;
		}
		
		@Override
		@RosettaAttribute("currentDealAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currentDealAmount")
		public MoneyWithParticipantShare getCurrentDealAmount() {
			return currentDealAmount;
		}
		
		@Override
		public DealSummary build() {
			return this;
		}
		
		@Override
		public DealSummary.DealSummaryBuilder toBuilder() {
			DealSummary.DealSummaryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DealSummary.DealSummaryBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getIssuerPartyReference()).ifPresent(builder::setIssuerPartyReference);
			ofNullable(getGuarantorPartyReference()).ifPresent(builder::setGuarantorPartyReference);
			ofNullable(getAgentPartyReference()).ifPresent(builder::setAgentPartyReference);
			ofNullable(getSyndicationLeadPartyReference()).ifPresent(builder::setSyndicationLeadPartyReference);
			ofNullable(getSyndicationCoLeadPartyReference()).ifPresent(builder::setSyndicationCoLeadPartyReference);
			ofNullable(getCreditAgreementDate()).ifPresent(builder::setCreditAgreementDate);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getIssuedAmount()).ifPresent(builder::setIssuedAmount);
			ofNullable(getCurrentDealAmount()).ifPresent(builder::setCurrentDealAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DealSummary _that = getType().cast(o);
		
			if (!Objects.equals(issuerPartyReference, _that.getIssuerPartyReference())) return false;
			if (!ListEquals.listEquals(guarantorPartyReference, _that.getGuarantorPartyReference())) return false;
			if (!Objects.equals(agentPartyReference, _that.getAgentPartyReference())) return false;
			if (!Objects.equals(syndicationLeadPartyReference, _that.getSyndicationLeadPartyReference())) return false;
			if (!ListEquals.listEquals(syndicationCoLeadPartyReference, _that.getSyndicationCoLeadPartyReference())) return false;
			if (!Objects.equals(creditAgreementDate, _that.getCreditAgreementDate())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(issuedAmount, _that.getIssuedAmount())) return false;
			if (!Objects.equals(currentDealAmount, _that.getCurrentDealAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (issuerPartyReference != null ? issuerPartyReference.hashCode() : 0);
			_result = 31 * _result + (guarantorPartyReference != null ? guarantorPartyReference.hashCode() : 0);
			_result = 31 * _result + (agentPartyReference != null ? agentPartyReference.hashCode() : 0);
			_result = 31 * _result + (syndicationLeadPartyReference != null ? syndicationLeadPartyReference.hashCode() : 0);
			_result = 31 * _result + (syndicationCoLeadPartyReference != null ? syndicationCoLeadPartyReference.hashCode() : 0);
			_result = 31 * _result + (creditAgreementDate != null ? creditAgreementDate.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (issuedAmount != null ? issuedAmount.hashCode() : 0);
			_result = 31 * _result + (currentDealAmount != null ? currentDealAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DealSummary {" +
				"issuerPartyReference=" + this.issuerPartyReference + ", " +
				"guarantorPartyReference=" + this.guarantorPartyReference + ", " +
				"agentPartyReference=" + this.agentPartyReference + ", " +
				"syndicationLeadPartyReference=" + this.syndicationLeadPartyReference + ", " +
				"syndicationCoLeadPartyReference=" + this.syndicationCoLeadPartyReference + ", " +
				"creditAgreementDate=" + this.creditAgreementDate + ", " +
				"currency=" + this.currency + ", " +
				"issuedAmount=" + this.issuedAmount + ", " +
				"currentDealAmount=" + this.currentDealAmount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DealSummary  ***********************/
	class DealSummaryBuilderImpl extends DealIdentifier.DealIdentifierBuilderImpl implements DealSummary.DealSummaryBuilder {
	
		protected PartyReference.PartyReferenceBuilder issuerPartyReference;
		protected List<PartyReference.PartyReferenceBuilder> guarantorPartyReference = new ArrayList<>();
		protected PartyReference.PartyReferenceBuilder agentPartyReference;
		protected PartyReference.PartyReferenceBuilder syndicationLeadPartyReference;
		protected List<PartyReference.PartyReferenceBuilder> syndicationCoLeadPartyReference = new ArrayList<>();
		protected ZonedDateTime creditAgreementDate;
		protected Currency.CurrencyBuilder currency;
		protected NonNegativeMoney.NonNegativeMoneyBuilder issuedAmount;
		protected MoneyWithParticipantShare.MoneyWithParticipantShareBuilder currentDealAmount;
		
		@Override
		@RosettaAttribute("issuerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("issuerPartyReference")
		public PartyReference.PartyReferenceBuilder getIssuerPartyReference() {
			return issuerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateIssuerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (issuerPartyReference!=null) {
				result = issuerPartyReference;
			}
			else {
				result = issuerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("guarantorPartyReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("guarantorPartyReference")
		public List<? extends PartyReference.PartyReferenceBuilder> getGuarantorPartyReference() {
			return guarantorPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateGuarantorPartyReference(int index) {
			if (guarantorPartyReference==null) {
				this.guarantorPartyReference = new ArrayList<>();
			}
			return getIndex(guarantorPartyReference, index, () -> {
						PartyReference.PartyReferenceBuilder newGuarantorPartyReference = PartyReference.builder();
						return newGuarantorPartyReference;
					});
		}
		
		@Override
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("agentPartyReference")
		public PartyReference.PartyReferenceBuilder getAgentPartyReference() {
			return agentPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateAgentPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (agentPartyReference!=null) {
				result = agentPartyReference;
			}
			else {
				result = agentPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("syndicationLeadPartyReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("syndicationLeadPartyReference")
		public PartyReference.PartyReferenceBuilder getSyndicationLeadPartyReference() {
			return syndicationLeadPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateSyndicationLeadPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (syndicationLeadPartyReference!=null) {
				result = syndicationLeadPartyReference;
			}
			else {
				result = syndicationLeadPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("syndicationCoLeadPartyReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("syndicationCoLeadPartyReference")
		public List<? extends PartyReference.PartyReferenceBuilder> getSyndicationCoLeadPartyReference() {
			return syndicationCoLeadPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateSyndicationCoLeadPartyReference(int index) {
			if (syndicationCoLeadPartyReference==null) {
				this.syndicationCoLeadPartyReference = new ArrayList<>();
			}
			return getIndex(syndicationCoLeadPartyReference, index, () -> {
						PartyReference.PartyReferenceBuilder newSyndicationCoLeadPartyReference = PartyReference.builder();
						return newSyndicationCoLeadPartyReference;
					});
		}
		
		@Override
		@RosettaAttribute("creditAgreementDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("creditAgreementDate")
		public ZonedDateTime getCreditAgreementDate() {
			return creditAgreementDate;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currency")
		public Currency.CurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency() {
			Currency.CurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("issuedAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("issuedAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getIssuedAmount() {
			return issuedAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateIssuedAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (issuedAmount!=null) {
				result = issuedAmount;
			}
			else {
				result = issuedAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currentDealAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("currentDealAmount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getCurrentDealAmount() {
			return currentDealAmount;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder getOrCreateCurrentDealAmount() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder result;
			if (currentDealAmount!=null) {
				result = currentDealAmount;
			}
			else {
				result = currentDealAmount = MoneyWithParticipantShare.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public DealSummary.DealSummaryBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public DealSummary.DealSummaryBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public DealSummary.DealSummaryBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public DealSummary.DealSummaryBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public DealSummary.DealSummaryBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds != null) {
				for (final InstrumentId toAdd : instrumentIds) {
					this.instrumentId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public DealSummary.DealSummaryBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
			if (instrumentIds == null) {
				this.instrumentId = new ArrayList<>();
			} else {
				this.instrumentId = instrumentIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public DealSummary.DealSummaryBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("issuerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("issuerPartyReference")
		@Override
		public DealSummary.DealSummaryBuilder setIssuerPartyReference(PartyReference _issuerPartyReference) {
			this.issuerPartyReference = _issuerPartyReference == null ? null : _issuerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("guarantorPartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("guarantorPartyReference")
		@Override
		public DealSummary.DealSummaryBuilder addGuarantorPartyReference(PartyReference _guarantorPartyReference) {
			if (_guarantorPartyReference != null) {
				this.guarantorPartyReference.add(_guarantorPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public DealSummary.DealSummaryBuilder addGuarantorPartyReference(PartyReference _guarantorPartyReference, int idx) {
			getIndex(this.guarantorPartyReference, idx, () -> _guarantorPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public DealSummary.DealSummaryBuilder addGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReferences) {
			if (guarantorPartyReferences != null) {
				for (final PartyReference toAdd : guarantorPartyReferences) {
					this.guarantorPartyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("guarantorPartyReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("guarantorPartyReference")
		@Override
		public DealSummary.DealSummaryBuilder setGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReferences) {
			if (guarantorPartyReferences == null) {
				this.guarantorPartyReference = new ArrayList<>();
			} else {
				this.guarantorPartyReference = guarantorPartyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("agentPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("agentPartyReference")
		@Override
		public DealSummary.DealSummaryBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("syndicationLeadPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("syndicationLeadPartyReference")
		@Override
		public DealSummary.DealSummaryBuilder setSyndicationLeadPartyReference(PartyReference _syndicationLeadPartyReference) {
			this.syndicationLeadPartyReference = _syndicationLeadPartyReference == null ? null : _syndicationLeadPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("syndicationCoLeadPartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("syndicationCoLeadPartyReference")
		@Override
		public DealSummary.DealSummaryBuilder addSyndicationCoLeadPartyReference(PartyReference _syndicationCoLeadPartyReference) {
			if (_syndicationCoLeadPartyReference != null) {
				this.syndicationCoLeadPartyReference.add(_syndicationCoLeadPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public DealSummary.DealSummaryBuilder addSyndicationCoLeadPartyReference(PartyReference _syndicationCoLeadPartyReference, int idx) {
			getIndex(this.syndicationCoLeadPartyReference, idx, () -> _syndicationCoLeadPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public DealSummary.DealSummaryBuilder addSyndicationCoLeadPartyReference(List<? extends PartyReference> syndicationCoLeadPartyReferences) {
			if (syndicationCoLeadPartyReferences != null) {
				for (final PartyReference toAdd : syndicationCoLeadPartyReferences) {
					this.syndicationCoLeadPartyReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("syndicationCoLeadPartyReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("syndicationCoLeadPartyReference")
		@Override
		public DealSummary.DealSummaryBuilder setSyndicationCoLeadPartyReference(List<? extends PartyReference> syndicationCoLeadPartyReferences) {
			if (syndicationCoLeadPartyReferences == null) {
				this.syndicationCoLeadPartyReference = new ArrayList<>();
			} else {
				this.syndicationCoLeadPartyReference = syndicationCoLeadPartyReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("creditAgreementDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("creditAgreementDate")
		@Override
		public DealSummary.DealSummaryBuilder setCreditAgreementDate(ZonedDateTime _creditAgreementDate) {
			this.creditAgreementDate = _creditAgreementDate == null ? null : _creditAgreementDate;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public DealSummary.DealSummaryBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("issuedAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("issuedAmount")
		@Override
		public DealSummary.DealSummaryBuilder setIssuedAmount(NonNegativeMoney _issuedAmount) {
			this.issuedAmount = _issuedAmount == null ? null : _issuedAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("currentDealAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currentDealAmount")
		@Override
		public DealSummary.DealSummaryBuilder setCurrentDealAmount(MoneyWithParticipantShare _currentDealAmount) {
			this.currentDealAmount = _currentDealAmount == null ? null : _currentDealAmount.toBuilder();
			return this;
		}
		
		@Override
		public DealSummary build() {
			return new DealSummary.DealSummaryImpl(this);
		}
		
		@Override
		public DealSummary.DealSummaryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DealSummary.DealSummaryBuilder prune() {
			super.prune();
			if (issuerPartyReference!=null && !issuerPartyReference.prune().hasData()) issuerPartyReference = null;
			guarantorPartyReference = guarantorPartyReference.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (agentPartyReference!=null && !agentPartyReference.prune().hasData()) agentPartyReference = null;
			if (syndicationLeadPartyReference!=null && !syndicationLeadPartyReference.prune().hasData()) syndicationLeadPartyReference = null;
			syndicationCoLeadPartyReference = syndicationCoLeadPartyReference.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (issuedAmount!=null && !issuedAmount.prune().hasData()) issuedAmount = null;
			if (currentDealAmount!=null && !currentDealAmount.prune().hasData()) currentDealAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getIssuerPartyReference()!=null && getIssuerPartyReference().hasData()) return true;
			if (getGuarantorPartyReference()!=null && getGuarantorPartyReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAgentPartyReference()!=null && getAgentPartyReference().hasData()) return true;
			if (getSyndicationLeadPartyReference()!=null && getSyndicationLeadPartyReference().hasData()) return true;
			if (getSyndicationCoLeadPartyReference()!=null && getSyndicationCoLeadPartyReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCreditAgreementDate()!=null) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getIssuedAmount()!=null && getIssuedAmount().hasData()) return true;
			if (getCurrentDealAmount()!=null && getCurrentDealAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DealSummary.DealSummaryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			DealSummary.DealSummaryBuilder o = (DealSummary.DealSummaryBuilder) other;
			
			merger.mergeRosetta(getIssuerPartyReference(), o.getIssuerPartyReference(), this::setIssuerPartyReference);
			merger.mergeRosetta(getGuarantorPartyReference(), o.getGuarantorPartyReference(), this::getOrCreateGuarantorPartyReference);
			merger.mergeRosetta(getAgentPartyReference(), o.getAgentPartyReference(), this::setAgentPartyReference);
			merger.mergeRosetta(getSyndicationLeadPartyReference(), o.getSyndicationLeadPartyReference(), this::setSyndicationLeadPartyReference);
			merger.mergeRosetta(getSyndicationCoLeadPartyReference(), o.getSyndicationCoLeadPartyReference(), this::getOrCreateSyndicationCoLeadPartyReference);
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getIssuedAmount(), o.getIssuedAmount(), this::setIssuedAmount);
			merger.mergeRosetta(getCurrentDealAmount(), o.getCurrentDealAmount(), this::setCurrentDealAmount);
			
			merger.mergeBasic(getCreditAgreementDate(), o.getCreditAgreementDate(), this::setCreditAgreementDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DealSummary _that = getType().cast(o);
		
			if (!Objects.equals(issuerPartyReference, _that.getIssuerPartyReference())) return false;
			if (!ListEquals.listEquals(guarantorPartyReference, _that.getGuarantorPartyReference())) return false;
			if (!Objects.equals(agentPartyReference, _that.getAgentPartyReference())) return false;
			if (!Objects.equals(syndicationLeadPartyReference, _that.getSyndicationLeadPartyReference())) return false;
			if (!ListEquals.listEquals(syndicationCoLeadPartyReference, _that.getSyndicationCoLeadPartyReference())) return false;
			if (!Objects.equals(creditAgreementDate, _that.getCreditAgreementDate())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(issuedAmount, _that.getIssuedAmount())) return false;
			if (!Objects.equals(currentDealAmount, _that.getCurrentDealAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (issuerPartyReference != null ? issuerPartyReference.hashCode() : 0);
			_result = 31 * _result + (guarantorPartyReference != null ? guarantorPartyReference.hashCode() : 0);
			_result = 31 * _result + (agentPartyReference != null ? agentPartyReference.hashCode() : 0);
			_result = 31 * _result + (syndicationLeadPartyReference != null ? syndicationLeadPartyReference.hashCode() : 0);
			_result = 31 * _result + (syndicationCoLeadPartyReference != null ? syndicationCoLeadPartyReference.hashCode() : 0);
			_result = 31 * _result + (creditAgreementDate != null ? creditAgreementDate.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (issuedAmount != null ? issuedAmount.hashCode() : 0);
			_result = 31 * _result + (currentDealAmount != null ? currentDealAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DealSummaryBuilder {" +
				"issuerPartyReference=" + this.issuerPartyReference + ", " +
				"guarantorPartyReference=" + this.guarantorPartyReference + ", " +
				"agentPartyReference=" + this.agentPartyReference + ", " +
				"syndicationLeadPartyReference=" + this.syndicationLeadPartyReference + ", " +
				"syndicationCoLeadPartyReference=" + this.syndicationCoLeadPartyReference + ", " +
				"creditAgreementDate=" + this.creditAgreementDate + ", " +
				"currency=" + this.currency + ", " +
				"issuedAmount=" + this.issuedAmount + ", " +
				"currentDealAmount=" + this.currentDealAmount +
			'}' + " " + super.toString();
		}
	}
}
