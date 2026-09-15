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
import fpml.consolidated.loan.meta.DealMeta;
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
 * Provision A syndicated bank loan deal (credit agreement) definition.
 *
 */
@RosettaDataType(value="Deal", builder=Deal.DealBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Deal", model="fpml", builder=Deal.DealBuilderImpl.class, version="2.1.1")
public interface Deal extends DealSummary {

	DealMeta metaData = new DealMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The transfer fee amount and rules. This applies to the commitment transfer of any facility within the deal structure.
	 *
	 */
	TransferFeeDefinition getTransferFee();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Groups of facilities which must be traded on a pro-rata basis. The ratio of facility trade amounts must be equal to the ratio of their corresponding global amounts.
	 *
	 */
	List<? extends ProRataFacilities> getProRataFacilities();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends LoanCovenantObligation> getCovenant();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends DealSequence> getDealSequence();

	/*********************** Build Methods  ***********************/
	Deal build();
	
	Deal.DealBuilder toBuilder();
	
	static Deal.DealBuilder builder() {
		return new Deal.DealBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Deal> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Deal> getType() {
		return Deal.class;
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
		processRosetta(path.newSubPath("transferFee"), processor, TransferFeeDefinition.class, getTransferFee());
		processRosetta(path.newSubPath("proRataFacilities"), processor, ProRataFacilities.class, getProRataFacilities());
		processRosetta(path.newSubPath("covenant"), processor, LoanCovenantObligation.class, getCovenant());
		processRosetta(path.newSubPath("dealSequence"), processor, DealSequence.class, getDealSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DealBuilder extends Deal, DealSummary.DealSummaryBuilder {
		TransferFeeDefinition.TransferFeeDefinitionBuilder getOrCreateTransferFee();
		@Override
		TransferFeeDefinition.TransferFeeDefinitionBuilder getTransferFee();
		ProRataFacilities.ProRataFacilitiesBuilder getOrCreateProRataFacilities(int index);
		@Override
		List<? extends ProRataFacilities.ProRataFacilitiesBuilder> getProRataFacilities();
		LoanCovenantObligation.LoanCovenantObligationBuilder getOrCreateCovenant(int index);
		@Override
		List<? extends LoanCovenantObligation.LoanCovenantObligationBuilder> getCovenant();
		DealSequence.DealSequenceBuilder getOrCreateDealSequence(int index);
		@Override
		List<? extends DealSequence.DealSequenceBuilder> getDealSequence();
		@Override
		Deal.DealBuilder setId(String id);
		@Override
		Deal.DealBuilder setPartyReference(PartyReference partyReference);
		@Override
		Deal.DealBuilder addInstrumentId(InstrumentId instrumentId);
		@Override
		Deal.DealBuilder addInstrumentId(InstrumentId instrumentId, int idx);
		@Override
		Deal.DealBuilder addInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		Deal.DealBuilder setInstrumentId(List<? extends InstrumentId> instrumentId);
		@Override
		Deal.DealBuilder setDescription(String description);
		@Override
		Deal.DealBuilder setIssuerPartyReference(PartyReference issuerPartyReference);
		@Override
		Deal.DealBuilder addGuarantorPartyReference(PartyReference guarantorPartyReference);
		@Override
		Deal.DealBuilder addGuarantorPartyReference(PartyReference guarantorPartyReference, int idx);
		@Override
		Deal.DealBuilder addGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReference);
		@Override
		Deal.DealBuilder setGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReference);
		@Override
		Deal.DealBuilder setAgentPartyReference(PartyReference agentPartyReference);
		@Override
		Deal.DealBuilder setSyndicationLeadPartyReference(PartyReference syndicationLeadPartyReference);
		@Override
		Deal.DealBuilder addSyndicationCoLeadPartyReference(PartyReference syndicationCoLeadPartyReference);
		@Override
		Deal.DealBuilder addSyndicationCoLeadPartyReference(PartyReference syndicationCoLeadPartyReference, int idx);
		@Override
		Deal.DealBuilder addSyndicationCoLeadPartyReference(List<? extends PartyReference> syndicationCoLeadPartyReference);
		@Override
		Deal.DealBuilder setSyndicationCoLeadPartyReference(List<? extends PartyReference> syndicationCoLeadPartyReference);
		@Override
		Deal.DealBuilder setCreditAgreementDate(ZonedDateTime creditAgreementDate);
		@Override
		Deal.DealBuilder setCurrency(Currency currency);
		@Override
		Deal.DealBuilder setIssuedAmount(NonNegativeMoney issuedAmount);
		@Override
		Deal.DealBuilder setCurrentDealAmount(MoneyWithParticipantShare currentDealAmount);
		Deal.DealBuilder setTransferFee(TransferFeeDefinition transferFee);
		Deal.DealBuilder addProRataFacilities(ProRataFacilities proRataFacilities);
		Deal.DealBuilder addProRataFacilities(ProRataFacilities proRataFacilities, int idx);
		Deal.DealBuilder addProRataFacilities(List<? extends ProRataFacilities> proRataFacilities);
		Deal.DealBuilder setProRataFacilities(List<? extends ProRataFacilities> proRataFacilities);
		Deal.DealBuilder addCovenant(LoanCovenantObligation covenant);
		Deal.DealBuilder addCovenant(LoanCovenantObligation covenant, int idx);
		Deal.DealBuilder addCovenant(List<? extends LoanCovenantObligation> covenant);
		Deal.DealBuilder setCovenant(List<? extends LoanCovenantObligation> covenant);
		Deal.DealBuilder addDealSequence(DealSequence dealSequence);
		Deal.DealBuilder addDealSequence(DealSequence dealSequence, int idx);
		Deal.DealBuilder addDealSequence(List<? extends DealSequence> dealSequence);
		Deal.DealBuilder setDealSequence(List<? extends DealSequence> dealSequence);

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
			processRosetta(path.newSubPath("transferFee"), processor, TransferFeeDefinition.TransferFeeDefinitionBuilder.class, getTransferFee());
			processRosetta(path.newSubPath("proRataFacilities"), processor, ProRataFacilities.ProRataFacilitiesBuilder.class, getProRataFacilities());
			processRosetta(path.newSubPath("covenant"), processor, LoanCovenantObligation.LoanCovenantObligationBuilder.class, getCovenant());
			processRosetta(path.newSubPath("dealSequence"), processor, DealSequence.DealSequenceBuilder.class, getDealSequence());
		}
		

		Deal.DealBuilder prune();
	}

	/*********************** Immutable Implementation of Deal  ***********************/
	class DealImpl extends DealSummary.DealSummaryImpl implements Deal {
		private final TransferFeeDefinition transferFee;
		private final List<? extends ProRataFacilities> proRataFacilities;
		private final List<? extends LoanCovenantObligation> covenant;
		private final List<? extends DealSequence> dealSequence;
		
		protected DealImpl(Deal.DealBuilder builder) {
			super(builder);
			this.transferFee = ofNullable(builder.getTransferFee()).map(f->f.build()).orElse(null);
			this.proRataFacilities = ofNullable(builder.getProRataFacilities()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.covenant = ofNullable(builder.getCovenant()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.dealSequence = ofNullable(builder.getDealSequence()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("transferFee")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transferFee")
		public TransferFeeDefinition getTransferFee() {
			return transferFee;
		}
		
		@Override
		@RosettaAttribute("proRataFacilities")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("proRataFacilities")
		public List<? extends ProRataFacilities> getProRataFacilities() {
			return proRataFacilities;
		}
		
		@Override
		@RosettaAttribute("covenant")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("covenant")
		public List<? extends LoanCovenantObligation> getCovenant() {
			return covenant;
		}
		
		@Override
		@RosettaAttribute("dealSequence")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("dealSequence")
		public List<? extends DealSequence> getDealSequence() {
			return dealSequence;
		}
		
		@Override
		public Deal build() {
			return this;
		}
		
		@Override
		public Deal.DealBuilder toBuilder() {
			Deal.DealBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Deal.DealBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTransferFee()).ifPresent(builder::setTransferFee);
			ofNullable(getProRataFacilities()).ifPresent(builder::setProRataFacilities);
			ofNullable(getCovenant()).ifPresent(builder::setCovenant);
			ofNullable(getDealSequence()).ifPresent(builder::setDealSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Deal _that = getType().cast(o);
		
			if (!Objects.equals(transferFee, _that.getTransferFee())) return false;
			if (!ListEquals.listEquals(proRataFacilities, _that.getProRataFacilities())) return false;
			if (!ListEquals.listEquals(covenant, _that.getCovenant())) return false;
			if (!ListEquals.listEquals(dealSequence, _that.getDealSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (transferFee != null ? transferFee.hashCode() : 0);
			_result = 31 * _result + (proRataFacilities != null ? proRataFacilities.hashCode() : 0);
			_result = 31 * _result + (covenant != null ? covenant.hashCode() : 0);
			_result = 31 * _result + (dealSequence != null ? dealSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Deal {" +
				"transferFee=" + this.transferFee + ", " +
				"proRataFacilities=" + this.proRataFacilities + ", " +
				"covenant=" + this.covenant + ", " +
				"dealSequence=" + this.dealSequence +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of Deal  ***********************/
	class DealBuilderImpl extends DealSummary.DealSummaryBuilderImpl implements Deal.DealBuilder {
	
		protected TransferFeeDefinition.TransferFeeDefinitionBuilder transferFee;
		protected List<ProRataFacilities.ProRataFacilitiesBuilder> proRataFacilities = new ArrayList<>();
		protected List<LoanCovenantObligation.LoanCovenantObligationBuilder> covenant = new ArrayList<>();
		protected List<DealSequence.DealSequenceBuilder> dealSequence = new ArrayList<>();
		
		@Override
		@RosettaAttribute("transferFee")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("transferFee")
		public TransferFeeDefinition.TransferFeeDefinitionBuilder getTransferFee() {
			return transferFee;
		}
		
		@Override
		public TransferFeeDefinition.TransferFeeDefinitionBuilder getOrCreateTransferFee() {
			TransferFeeDefinition.TransferFeeDefinitionBuilder result;
			if (transferFee!=null) {
				result = transferFee;
			}
			else {
				result = transferFee = TransferFeeDefinition.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("proRataFacilities")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("proRataFacilities")
		public List<? extends ProRataFacilities.ProRataFacilitiesBuilder> getProRataFacilities() {
			return proRataFacilities;
		}
		
		@Override
		public ProRataFacilities.ProRataFacilitiesBuilder getOrCreateProRataFacilities(int index) {
			if (proRataFacilities==null) {
				this.proRataFacilities = new ArrayList<>();
			}
			return getIndex(proRataFacilities, index, () -> {
						ProRataFacilities.ProRataFacilitiesBuilder newProRataFacilities = ProRataFacilities.builder();
						return newProRataFacilities;
					});
		}
		
		@Override
		@RosettaAttribute("covenant")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("covenant")
		public List<? extends LoanCovenantObligation.LoanCovenantObligationBuilder> getCovenant() {
			return covenant;
		}
		
		@Override
		public LoanCovenantObligation.LoanCovenantObligationBuilder getOrCreateCovenant(int index) {
			if (covenant==null) {
				this.covenant = new ArrayList<>();
			}
			return getIndex(covenant, index, () -> {
						LoanCovenantObligation.LoanCovenantObligationBuilder newCovenant = LoanCovenantObligation.builder();
						return newCovenant;
					});
		}
		
		@Override
		@RosettaAttribute("dealSequence")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("dealSequence")
		public List<? extends DealSequence.DealSequenceBuilder> getDealSequence() {
			return dealSequence;
		}
		
		@Override
		public DealSequence.DealSequenceBuilder getOrCreateDealSequence(int index) {
			if (dealSequence==null) {
				this.dealSequence = new ArrayList<>();
			}
			return getIndex(dealSequence, index, () -> {
						DealSequence.DealSequenceBuilder newDealSequence = DealSequence.builder();
						return newDealSequence;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Deal.DealBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public Deal.DealBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("instrumentId")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("instrumentId")
		@Override
		public Deal.DealBuilder addInstrumentId(InstrumentId _instrumentId) {
			if (_instrumentId != null) {
				this.instrumentId.add(_instrumentId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Deal.DealBuilder addInstrumentId(InstrumentId _instrumentId, int idx) {
			getIndex(this.instrumentId, idx, () -> _instrumentId.toBuilder());
			return this;
		}
		
		@Override
		public Deal.DealBuilder addInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public Deal.DealBuilder setInstrumentId(List<? extends InstrumentId> instrumentIds) {
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
		public Deal.DealBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("issuerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("issuerPartyReference")
		@Override
		public Deal.DealBuilder setIssuerPartyReference(PartyReference _issuerPartyReference) {
			this.issuerPartyReference = _issuerPartyReference == null ? null : _issuerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("guarantorPartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("guarantorPartyReference")
		@Override
		public Deal.DealBuilder addGuarantorPartyReference(PartyReference _guarantorPartyReference) {
			if (_guarantorPartyReference != null) {
				this.guarantorPartyReference.add(_guarantorPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public Deal.DealBuilder addGuarantorPartyReference(PartyReference _guarantorPartyReference, int idx) {
			getIndex(this.guarantorPartyReference, idx, () -> _guarantorPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public Deal.DealBuilder addGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReferences) {
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
		public Deal.DealBuilder setGuarantorPartyReference(List<? extends PartyReference> guarantorPartyReferences) {
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
		public Deal.DealBuilder setAgentPartyReference(PartyReference _agentPartyReference) {
			this.agentPartyReference = _agentPartyReference == null ? null : _agentPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("syndicationLeadPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("syndicationLeadPartyReference")
		@Override
		public Deal.DealBuilder setSyndicationLeadPartyReference(PartyReference _syndicationLeadPartyReference) {
			this.syndicationLeadPartyReference = _syndicationLeadPartyReference == null ? null : _syndicationLeadPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("syndicationCoLeadPartyReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("syndicationCoLeadPartyReference")
		@Override
		public Deal.DealBuilder addSyndicationCoLeadPartyReference(PartyReference _syndicationCoLeadPartyReference) {
			if (_syndicationCoLeadPartyReference != null) {
				this.syndicationCoLeadPartyReference.add(_syndicationCoLeadPartyReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public Deal.DealBuilder addSyndicationCoLeadPartyReference(PartyReference _syndicationCoLeadPartyReference, int idx) {
			getIndex(this.syndicationCoLeadPartyReference, idx, () -> _syndicationCoLeadPartyReference.toBuilder());
			return this;
		}
		
		@Override
		public Deal.DealBuilder addSyndicationCoLeadPartyReference(List<? extends PartyReference> syndicationCoLeadPartyReferences) {
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
		public Deal.DealBuilder setSyndicationCoLeadPartyReference(List<? extends PartyReference> syndicationCoLeadPartyReferences) {
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
		public Deal.DealBuilder setCreditAgreementDate(ZonedDateTime _creditAgreementDate) {
			this.creditAgreementDate = _creditAgreementDate == null ? null : _creditAgreementDate;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public Deal.DealBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("issuedAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("issuedAmount")
		@Override
		public Deal.DealBuilder setIssuedAmount(NonNegativeMoney _issuedAmount) {
			this.issuedAmount = _issuedAmount == null ? null : _issuedAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("currentDealAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currentDealAmount")
		@Override
		public Deal.DealBuilder setCurrentDealAmount(MoneyWithParticipantShare _currentDealAmount) {
			this.currentDealAmount = _currentDealAmount == null ? null : _currentDealAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("transferFee")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("transferFee")
		@Override
		public Deal.DealBuilder setTransferFee(TransferFeeDefinition _transferFee) {
			this.transferFee = _transferFee == null ? null : _transferFee.toBuilder();
			return this;
		}
		
		@RosettaAttribute("proRataFacilities")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("proRataFacilities")
		@Override
		public Deal.DealBuilder addProRataFacilities(ProRataFacilities _proRataFacilities) {
			if (_proRataFacilities != null) {
				this.proRataFacilities.add(_proRataFacilities.toBuilder());
			}
			return this;
		}
		
		@Override
		public Deal.DealBuilder addProRataFacilities(ProRataFacilities _proRataFacilities, int idx) {
			getIndex(this.proRataFacilities, idx, () -> _proRataFacilities.toBuilder());
			return this;
		}
		
		@Override
		public Deal.DealBuilder addProRataFacilities(List<? extends ProRataFacilities> proRataFacilitiess) {
			if (proRataFacilitiess != null) {
				for (final ProRataFacilities toAdd : proRataFacilitiess) {
					this.proRataFacilities.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("proRataFacilities")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("proRataFacilities")
		@Override
		public Deal.DealBuilder setProRataFacilities(List<? extends ProRataFacilities> proRataFacilitiess) {
			if (proRataFacilitiess == null) {
				this.proRataFacilities = new ArrayList<>();
			} else {
				this.proRataFacilities = proRataFacilitiess.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("covenant")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("covenant")
		@Override
		public Deal.DealBuilder addCovenant(LoanCovenantObligation _covenant) {
			if (_covenant != null) {
				this.covenant.add(_covenant.toBuilder());
			}
			return this;
		}
		
		@Override
		public Deal.DealBuilder addCovenant(LoanCovenantObligation _covenant, int idx) {
			getIndex(this.covenant, idx, () -> _covenant.toBuilder());
			return this;
		}
		
		@Override
		public Deal.DealBuilder addCovenant(List<? extends LoanCovenantObligation> covenants) {
			if (covenants != null) {
				for (final LoanCovenantObligation toAdd : covenants) {
					this.covenant.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("covenant")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("covenant")
		@Override
		public Deal.DealBuilder setCovenant(List<? extends LoanCovenantObligation> covenants) {
			if (covenants == null) {
				this.covenant = new ArrayList<>();
			} else {
				this.covenant = covenants.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("dealSequence")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("dealSequence")
		@Override
		public Deal.DealBuilder addDealSequence(DealSequence _dealSequence) {
			if (_dealSequence != null) {
				this.dealSequence.add(_dealSequence.toBuilder());
			}
			return this;
		}
		
		@Override
		public Deal.DealBuilder addDealSequence(DealSequence _dealSequence, int idx) {
			getIndex(this.dealSequence, idx, () -> _dealSequence.toBuilder());
			return this;
		}
		
		@Override
		public Deal.DealBuilder addDealSequence(List<? extends DealSequence> dealSequences) {
			if (dealSequences != null) {
				for (final DealSequence toAdd : dealSequences) {
					this.dealSequence.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("dealSequence")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("dealSequence")
		@Override
		public Deal.DealBuilder setDealSequence(List<? extends DealSequence> dealSequences) {
			if (dealSequences == null) {
				this.dealSequence = new ArrayList<>();
			} else {
				this.dealSequence = dealSequences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Deal build() {
			return new Deal.DealImpl(this);
		}
		
		@Override
		public Deal.DealBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Deal.DealBuilder prune() {
			super.prune();
			if (transferFee!=null && !transferFee.prune().hasData()) transferFee = null;
			proRataFacilities = proRataFacilities.stream().filter(b->b!=null).<ProRataFacilities.ProRataFacilitiesBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			covenant = covenant.stream().filter(b->b!=null).<LoanCovenantObligation.LoanCovenantObligationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			dealSequence = dealSequence.stream().filter(b->b!=null).<DealSequence.DealSequenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTransferFee()!=null && getTransferFee().hasData()) return true;
			if (getProRataFacilities()!=null && getProRataFacilities().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCovenant()!=null && getCovenant().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDealSequence()!=null && getDealSequence().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Deal.DealBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			Deal.DealBuilder o = (Deal.DealBuilder) other;
			
			merger.mergeRosetta(getTransferFee(), o.getTransferFee(), this::setTransferFee);
			merger.mergeRosetta(getProRataFacilities(), o.getProRataFacilities(), this::getOrCreateProRataFacilities);
			merger.mergeRosetta(getCovenant(), o.getCovenant(), this::getOrCreateCovenant);
			merger.mergeRosetta(getDealSequence(), o.getDealSequence(), this::getOrCreateDealSequence);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Deal _that = getType().cast(o);
		
			if (!Objects.equals(transferFee, _that.getTransferFee())) return false;
			if (!ListEquals.listEquals(proRataFacilities, _that.getProRataFacilities())) return false;
			if (!ListEquals.listEquals(covenant, _that.getCovenant())) return false;
			if (!ListEquals.listEquals(dealSequence, _that.getDealSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (transferFee != null ? transferFee.hashCode() : 0);
			_result = 31 * _result + (proRataFacilities != null ? proRataFacilities.hashCode() : 0);
			_result = 31 * _result + (covenant != null ? covenant.hashCode() : 0);
			_result = 31 * _result + (dealSequence != null ? dealSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DealBuilder {" +
				"transferFee=" + this.transferFee + ", " +
				"proRataFacilities=" + this.proRataFacilities + ", " +
				"covenant=" + this.covenant + ", " +
				"dealSequence=" + this.dealSequence +
			'}' + " " + super.toString();
		}
	}
}
