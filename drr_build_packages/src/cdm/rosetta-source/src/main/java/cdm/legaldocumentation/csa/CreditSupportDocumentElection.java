package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.Party;
import cdm.legaldocumentation.common.CreditSupportDocumentTermsEnum;
import cdm.legaldocumentation.common.LegalAgreement;
import cdm.legaldocumentation.common.LegalAgreementIdentification;
import cdm.legaldocumentation.csa.meta.CreditSupportDocumentElectionMeta;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The party election of Credit Support Provider(s), if any.
 * @version 6.23.0
 */
@RosettaDataType(value="CreditSupportDocumentElection", builder=CreditSupportDocumentElection.CreditSupportDocumentElectionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CreditSupportDocumentElection", model="cdm", builder=CreditSupportDocumentElection.CreditSupportDocumentElectionBuilderImpl.class, version="6.23.0")
public interface CreditSupportDocumentElection extends RosettaModelObject {

	CreditSupportDocumentElectionMeta metaData = new CreditSupportDocumentElectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	Party getParty();
	/**
	 * Specification of the Credit Support Document terms.
	 */
	CreditSupportDocumentTermsEnum getCreditSupportDocumentTerms();
	/**
	 * If a Credit Support Document is specified but not yet in CDM representation, it can still be captured. This argument should be used if the creditSupportDocument argument cannot be used due to not being able to represent the document fully in CDM format.
	 */
	List<? extends LegalAgreementIdentification> getCreditSupportDocumentTypes();
	/**
	 * The specified Credit Support Document(s), if any.
	 */
	List<? extends LegalAgreement> getCreditSupportDocument();
	/**
	 * Specification of a document when not captured under RelatedAgreement.
	 */
	String getBespokeCreditSuppportDocument();

	/*********************** Build Methods  ***********************/
	CreditSupportDocumentElection build();
	
	CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder toBuilder();
	
	static CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder builder() {
		return new CreditSupportDocumentElection.CreditSupportDocumentElectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditSupportDocumentElection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditSupportDocumentElection> getType() {
		return CreditSupportDocumentElection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processor.processBasic(path.newSubPath("creditSupportDocumentTerms"), CreditSupportDocumentTermsEnum.class, getCreditSupportDocumentTerms(), this);
		processRosetta(path.newSubPath("creditSupportDocumentTypes"), processor, LegalAgreementIdentification.class, getCreditSupportDocumentTypes());
		processRosetta(path.newSubPath("creditSupportDocument"), processor, LegalAgreement.class, getCreditSupportDocument());
		processor.processBasic(path.newSubPath("bespokeCreditSuppportDocument"), String.class, getBespokeCreditSuppportDocument(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditSupportDocumentElectionBuilder extends CreditSupportDocumentElection, RosettaModelObjectBuilder {
		Party.PartyBuilder getOrCreateParty();
		@Override
		Party.PartyBuilder getParty();
		LegalAgreementIdentification.LegalAgreementIdentificationBuilder getOrCreateCreditSupportDocumentTypes(int index);
		@Override
		List<? extends LegalAgreementIdentification.LegalAgreementIdentificationBuilder> getCreditSupportDocumentTypes();
		LegalAgreement.LegalAgreementBuilder getOrCreateCreditSupportDocument(int index);
		@Override
		List<? extends LegalAgreement.LegalAgreementBuilder> getCreditSupportDocument();
		CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder setParty(Party party);
		CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder setCreditSupportDocumentTerms(CreditSupportDocumentTermsEnum creditSupportDocumentTerms);
		CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder addCreditSupportDocumentTypes(LegalAgreementIdentification creditSupportDocumentTypes);
		CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder addCreditSupportDocumentTypes(LegalAgreementIdentification creditSupportDocumentTypes, int idx);
		CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder addCreditSupportDocumentTypes(List<? extends LegalAgreementIdentification> creditSupportDocumentTypes);
		CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder setCreditSupportDocumentTypes(List<? extends LegalAgreementIdentification> creditSupportDocumentTypes);
		CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder addCreditSupportDocument(LegalAgreement creditSupportDocument);
		CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder addCreditSupportDocument(LegalAgreement creditSupportDocument, int idx);
		CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder addCreditSupportDocument(List<? extends LegalAgreement> creditSupportDocument);
		CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder setCreditSupportDocument(List<? extends LegalAgreement> creditSupportDocument);
		CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder setBespokeCreditSuppportDocument(String bespokeCreditSuppportDocument);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processor.processBasic(path.newSubPath("creditSupportDocumentTerms"), CreditSupportDocumentTermsEnum.class, getCreditSupportDocumentTerms(), this);
			processRosetta(path.newSubPath("creditSupportDocumentTypes"), processor, LegalAgreementIdentification.LegalAgreementIdentificationBuilder.class, getCreditSupportDocumentTypes());
			processRosetta(path.newSubPath("creditSupportDocument"), processor, LegalAgreement.LegalAgreementBuilder.class, getCreditSupportDocument());
			processor.processBasic(path.newSubPath("bespokeCreditSuppportDocument"), String.class, getBespokeCreditSuppportDocument(), this);
		}
		

		CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder prune();
	}

	/*********************** Immutable Implementation of CreditSupportDocumentElection  ***********************/
	class CreditSupportDocumentElectionImpl implements CreditSupportDocumentElection {
		private final Party party;
		private final CreditSupportDocumentTermsEnum creditSupportDocumentTerms;
		private final List<? extends LegalAgreementIdentification> creditSupportDocumentTypes;
		private final List<? extends LegalAgreement> creditSupportDocument;
		private final String bespokeCreditSuppportDocument;
		
		protected CreditSupportDocumentElectionImpl(CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder builder) {
			this.party = ofNullable(builder.getParty()).map(f->f.build()).orElse(null);
			this.creditSupportDocumentTerms = builder.getCreditSupportDocumentTerms();
			this.creditSupportDocumentTypes = ofNullable(builder.getCreditSupportDocumentTypes()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.creditSupportDocument = ofNullable(builder.getCreditSupportDocument()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.bespokeCreditSuppportDocument = builder.getBespokeCreditSuppportDocument();
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public Party getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("creditSupportDocumentTerms")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("creditSupportDocumentTerms")
		public CreditSupportDocumentTermsEnum getCreditSupportDocumentTerms() {
			return creditSupportDocumentTerms;
		}
		
		@Override
		@RosettaAttribute("creditSupportDocumentTypes")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("creditSupportDocumentTypes")
		public List<? extends LegalAgreementIdentification> getCreditSupportDocumentTypes() {
			return creditSupportDocumentTypes;
		}
		
		@Override
		@RosettaAttribute("creditSupportDocument")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("creditSupportDocument")
		public List<? extends LegalAgreement> getCreditSupportDocument() {
			return creditSupportDocument;
		}
		
		@Override
		@RosettaAttribute("bespokeCreditSuppportDocument")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bespokeCreditSuppportDocument")
		public String getBespokeCreditSuppportDocument() {
			return bespokeCreditSuppportDocument;
		}
		
		@Override
		public CreditSupportDocumentElection build() {
			return this;
		}
		
		@Override
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder toBuilder() {
			CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getCreditSupportDocumentTerms()).ifPresent(builder::setCreditSupportDocumentTerms);
			ofNullable(getCreditSupportDocumentTypes()).ifPresent(builder::setCreditSupportDocumentTypes);
			ofNullable(getCreditSupportDocument()).ifPresent(builder::setCreditSupportDocument);
			ofNullable(getBespokeCreditSuppportDocument()).ifPresent(builder::setBespokeCreditSuppportDocument);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportDocumentElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(creditSupportDocumentTerms, _that.getCreditSupportDocumentTerms())) return false;
			if (!ListEquals.listEquals(creditSupportDocumentTypes, _that.getCreditSupportDocumentTypes())) return false;
			if (!ListEquals.listEquals(creditSupportDocument, _that.getCreditSupportDocument())) return false;
			if (!Objects.equals(bespokeCreditSuppportDocument, _that.getBespokeCreditSuppportDocument())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (creditSupportDocumentTerms != null ? creditSupportDocumentTerms.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (creditSupportDocumentTypes != null ? creditSupportDocumentTypes.hashCode() : 0);
			_result = 31 * _result + (creditSupportDocument != null ? creditSupportDocument.hashCode() : 0);
			_result = 31 * _result + (bespokeCreditSuppportDocument != null ? bespokeCreditSuppportDocument.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportDocumentElection {" +
				"party=" + this.party + ", " +
				"creditSupportDocumentTerms=" + this.creditSupportDocumentTerms + ", " +
				"creditSupportDocumentTypes=" + this.creditSupportDocumentTypes + ", " +
				"creditSupportDocument=" + this.creditSupportDocument + ", " +
				"bespokeCreditSuppportDocument=" + this.bespokeCreditSuppportDocument +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditSupportDocumentElection  ***********************/
	class CreditSupportDocumentElectionBuilderImpl implements CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder {
	
		protected Party.PartyBuilder party;
		protected CreditSupportDocumentTermsEnum creditSupportDocumentTerms;
		protected List<LegalAgreementIdentification.LegalAgreementIdentificationBuilder> creditSupportDocumentTypes = new ArrayList<>();
		protected List<LegalAgreement.LegalAgreementBuilder> creditSupportDocument = new ArrayList<>();
		protected String bespokeCreditSuppportDocument;
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public Party.PartyBuilder getParty() {
			return party;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateParty() {
			Party.PartyBuilder result;
			if (party!=null) {
				result = party;
			}
			else {
				result = party = Party.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditSupportDocumentTerms")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("creditSupportDocumentTerms")
		public CreditSupportDocumentTermsEnum getCreditSupportDocumentTerms() {
			return creditSupportDocumentTerms;
		}
		
		@Override
		@RosettaAttribute("creditSupportDocumentTypes")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("creditSupportDocumentTypes")
		public List<? extends LegalAgreementIdentification.LegalAgreementIdentificationBuilder> getCreditSupportDocumentTypes() {
			return creditSupportDocumentTypes;
		}
		
		@Override
		public LegalAgreementIdentification.LegalAgreementIdentificationBuilder getOrCreateCreditSupportDocumentTypes(int index) {
			if (creditSupportDocumentTypes==null) {
				this.creditSupportDocumentTypes = new ArrayList<>();
			}
			return getIndex(creditSupportDocumentTypes, index, () -> {
						LegalAgreementIdentification.LegalAgreementIdentificationBuilder newCreditSupportDocumentTypes = LegalAgreementIdentification.builder();
						return newCreditSupportDocumentTypes;
					});
		}
		
		@Override
		@RosettaAttribute("creditSupportDocument")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("creditSupportDocument")
		public List<? extends LegalAgreement.LegalAgreementBuilder> getCreditSupportDocument() {
			return creditSupportDocument;
		}
		
		@Override
		public LegalAgreement.LegalAgreementBuilder getOrCreateCreditSupportDocument(int index) {
			if (creditSupportDocument==null) {
				this.creditSupportDocument = new ArrayList<>();
			}
			return getIndex(creditSupportDocument, index, () -> {
						LegalAgreement.LegalAgreementBuilder newCreditSupportDocument = LegalAgreement.builder();
						return newCreditSupportDocument;
					});
		}
		
		@Override
		@RosettaAttribute("bespokeCreditSuppportDocument")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bespokeCreditSuppportDocument")
		public String getBespokeCreditSuppportDocument() {
			return bespokeCreditSuppportDocument;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder setParty(Party _party) {
			this.party = _party == null ? null : _party.toBuilder();
			return this;
		}
		
		@RosettaAttribute("creditSupportDocumentTerms")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("creditSupportDocumentTerms")
		@Override
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder setCreditSupportDocumentTerms(CreditSupportDocumentTermsEnum _creditSupportDocumentTerms) {
			this.creditSupportDocumentTerms = _creditSupportDocumentTerms == null ? null : _creditSupportDocumentTerms;
			return this;
		}
		
		@RosettaAttribute("creditSupportDocumentTypes")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("creditSupportDocumentTypes")
		@Override
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder addCreditSupportDocumentTypes(LegalAgreementIdentification _creditSupportDocumentTypes) {
			if (_creditSupportDocumentTypes != null) {
				this.creditSupportDocumentTypes.add(_creditSupportDocumentTypes.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder addCreditSupportDocumentTypes(LegalAgreementIdentification _creditSupportDocumentTypes, int idx) {
			getIndex(this.creditSupportDocumentTypes, idx, () -> _creditSupportDocumentTypes.toBuilder());
			return this;
		}
		
		@Override
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder addCreditSupportDocumentTypes(List<? extends LegalAgreementIdentification> creditSupportDocumentTypess) {
			if (creditSupportDocumentTypess != null) {
				for (final LegalAgreementIdentification toAdd : creditSupportDocumentTypess) {
					this.creditSupportDocumentTypes.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("creditSupportDocumentTypes")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("creditSupportDocumentTypes")
		@Override
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder setCreditSupportDocumentTypes(List<? extends LegalAgreementIdentification> creditSupportDocumentTypess) {
			if (creditSupportDocumentTypess == null) {
				this.creditSupportDocumentTypes = new ArrayList<>();
			} else {
				this.creditSupportDocumentTypes = creditSupportDocumentTypess.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("creditSupportDocument")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("creditSupportDocument")
		@Override
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder addCreditSupportDocument(LegalAgreement _creditSupportDocument) {
			if (_creditSupportDocument != null) {
				this.creditSupportDocument.add(_creditSupportDocument.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder addCreditSupportDocument(LegalAgreement _creditSupportDocument, int idx) {
			getIndex(this.creditSupportDocument, idx, () -> _creditSupportDocument.toBuilder());
			return this;
		}
		
		@Override
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder addCreditSupportDocument(List<? extends LegalAgreement> creditSupportDocuments) {
			if (creditSupportDocuments != null) {
				for (final LegalAgreement toAdd : creditSupportDocuments) {
					this.creditSupportDocument.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("creditSupportDocument")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("creditSupportDocument")
		@Override
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder setCreditSupportDocument(List<? extends LegalAgreement> creditSupportDocuments) {
			if (creditSupportDocuments == null) {
				this.creditSupportDocument = new ArrayList<>();
			} else {
				this.creditSupportDocument = creditSupportDocuments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("bespokeCreditSuppportDocument")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bespokeCreditSuppportDocument")
		@Override
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder setBespokeCreditSuppportDocument(String _bespokeCreditSuppportDocument) {
			this.bespokeCreditSuppportDocument = _bespokeCreditSuppportDocument == null ? null : _bespokeCreditSuppportDocument;
			return this;
		}
		
		@Override
		public CreditSupportDocumentElection build() {
			return new CreditSupportDocumentElection.CreditSupportDocumentElectionImpl(this);
		}
		
		@Override
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder prune() {
			if (party!=null && !party.prune().hasData()) party = null;
			creditSupportDocumentTypes = creditSupportDocumentTypes.stream().filter(b->b!=null).<LegalAgreementIdentification.LegalAgreementIdentificationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			creditSupportDocument = creditSupportDocument.stream().filter(b->b!=null).<LegalAgreement.LegalAgreementBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null && getParty().hasData()) return true;
			if (getCreditSupportDocumentTerms()!=null) return true;
			if (getCreditSupportDocumentTypes()!=null && getCreditSupportDocumentTypes().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCreditSupportDocument()!=null && getCreditSupportDocument().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBespokeCreditSuppportDocument()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder o = (CreditSupportDocumentElection.CreditSupportDocumentElectionBuilder) other;
			
			merger.mergeRosetta(getParty(), o.getParty(), this::setParty);
			merger.mergeRosetta(getCreditSupportDocumentTypes(), o.getCreditSupportDocumentTypes(), this::getOrCreateCreditSupportDocumentTypes);
			merger.mergeRosetta(getCreditSupportDocument(), o.getCreditSupportDocument(), this::getOrCreateCreditSupportDocument);
			
			merger.mergeBasic(getCreditSupportDocumentTerms(), o.getCreditSupportDocumentTerms(), this::setCreditSupportDocumentTerms);
			merger.mergeBasic(getBespokeCreditSuppportDocument(), o.getBespokeCreditSuppportDocument(), this::setBespokeCreditSuppportDocument);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportDocumentElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(creditSupportDocumentTerms, _that.getCreditSupportDocumentTerms())) return false;
			if (!ListEquals.listEquals(creditSupportDocumentTypes, _that.getCreditSupportDocumentTypes())) return false;
			if (!ListEquals.listEquals(creditSupportDocument, _that.getCreditSupportDocument())) return false;
			if (!Objects.equals(bespokeCreditSuppportDocument, _that.getBespokeCreditSuppportDocument())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (creditSupportDocumentTerms != null ? creditSupportDocumentTerms.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (creditSupportDocumentTypes != null ? creditSupportDocumentTypes.hashCode() : 0);
			_result = 31 * _result + (creditSupportDocument != null ? creditSupportDocument.hashCode() : 0);
			_result = 31 * _result + (bespokeCreditSuppportDocument != null ? bespokeCreditSuppportDocument.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportDocumentElectionBuilder {" +
				"party=" + this.party + ", " +
				"creditSupportDocumentTerms=" + this.creditSupportDocumentTerms + ", " +
				"creditSupportDocumentTypes=" + this.creditSupportDocumentTypes + ", " +
				"creditSupportDocument=" + this.creditSupportDocument + ", " +
				"bespokeCreditSuppportDocument=" + this.bespokeCreditSuppportDocument +
			'}';
		}
	}
}
