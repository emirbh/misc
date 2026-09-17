package cdm.legaldocumentation.master.isda;

import cdm.legaldocumentation.common.AddressForNotices;
import cdm.legaldocumentation.csa.CreditSupportDocument;
import cdm.legaldocumentation.csa.CreditSupportProvider;
import cdm.legaldocumentation.master.MasterAgreementBase;
import cdm.legaldocumentation.master.isda.meta.MasterAgreementMeta;
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
 * The set of elections that define an ISDA Master Agreement.
 * @version 6.23.0
 */
@RosettaDataType(value="MasterAgreement", builder=MasterAgreement.MasterAgreementBuilderImpl.class, version="6.23.0")
@RuneDataType(value="MasterAgreement", model="cdm", builder=MasterAgreement.MasterAgreementBuilderImpl.class, version="6.23.0")
public interface MasterAgreement extends MasterAgreementBase {

	MasterAgreementMeta metaData = new MasterAgreementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The specification of whether there is an automatic occurrence of an Early Termination Date in respect of Transactions upon the occurrence of certain bankruptcy / insolvency related events.
	 */
	AutomaticEarlyTermination getAutomaticEarlyTermination();
	/**
	 * Specification of the currency in which the termination payment is made (including the process by which such currency is determined).
	 */
	TerminationCurrency getTerminationCurrency();
	/**
	 * Specification of the address and other details for notices.
	 */
	AddressForNotices getAddressForNotices();
	/**
	 * Specification of whether the Governing Law clause extends to Non-Contractual Obligations (True) or does not extend to Non-Contractual Obligations (False).
	 */
	Boolean getNonContractualObligations();
	/**
	 * Identification of party specific Credit Support Documents applicable to the document.
	 */
	CreditSupportDocument getCreditSupportDocument();
	/**
	 * Identification of party specific Credit Support Providers applicable to the document.
	 */
	CreditSupportProvider getCreditSupportProvider();
	/**
	 * A provision that allows each party to specify its Specified Entities for certain Events of Default and Termination Events.
	 */
	List<? extends SpecifiedEntities> getSpecifiedEntities();

	/*********************** Build Methods  ***********************/
	MasterAgreement build();
	
	MasterAgreement.MasterAgreementBuilder toBuilder();
	
	static MasterAgreement.MasterAgreementBuilder builder() {
		return new MasterAgreement.MasterAgreementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MasterAgreement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MasterAgreement> getType() {
		return MasterAgreement.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("automaticEarlyTermination"), processor, AutomaticEarlyTermination.class, getAutomaticEarlyTermination());
		processRosetta(path.newSubPath("terminationCurrency"), processor, TerminationCurrency.class, getTerminationCurrency());
		processRosetta(path.newSubPath("addressForNotices"), processor, AddressForNotices.class, getAddressForNotices());
		processor.processBasic(path.newSubPath("nonContractualObligations"), Boolean.class, getNonContractualObligations(), this);
		processRosetta(path.newSubPath("creditSupportDocument"), processor, CreditSupportDocument.class, getCreditSupportDocument());
		processRosetta(path.newSubPath("creditSupportProvider"), processor, CreditSupportProvider.class, getCreditSupportProvider());
		processRosetta(path.newSubPath("specifiedEntities"), processor, SpecifiedEntities.class, getSpecifiedEntities());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MasterAgreementBuilder extends MasterAgreement, MasterAgreementBase.MasterAgreementBaseBuilder {
		AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder getOrCreateAutomaticEarlyTermination();
		@Override
		AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder getAutomaticEarlyTermination();
		TerminationCurrency.TerminationCurrencyBuilder getOrCreateTerminationCurrency();
		@Override
		TerminationCurrency.TerminationCurrencyBuilder getTerminationCurrency();
		AddressForNotices.AddressForNoticesBuilder getOrCreateAddressForNotices();
		@Override
		AddressForNotices.AddressForNoticesBuilder getAddressForNotices();
		CreditSupportDocument.CreditSupportDocumentBuilder getOrCreateCreditSupportDocument();
		@Override
		CreditSupportDocument.CreditSupportDocumentBuilder getCreditSupportDocument();
		CreditSupportProvider.CreditSupportProviderBuilder getOrCreateCreditSupportProvider();
		@Override
		CreditSupportProvider.CreditSupportProviderBuilder getCreditSupportProvider();
		SpecifiedEntities.SpecifiedEntitiesBuilder getOrCreateSpecifiedEntities(int index);
		@Override
		List<? extends SpecifiedEntities.SpecifiedEntitiesBuilder> getSpecifiedEntities();
		MasterAgreement.MasterAgreementBuilder setAutomaticEarlyTermination(AutomaticEarlyTermination automaticEarlyTermination);
		MasterAgreement.MasterAgreementBuilder setTerminationCurrency(TerminationCurrency terminationCurrency);
		MasterAgreement.MasterAgreementBuilder setAddressForNotices(AddressForNotices addressForNotices);
		MasterAgreement.MasterAgreementBuilder setNonContractualObligations(Boolean nonContractualObligations);
		MasterAgreement.MasterAgreementBuilder setCreditSupportDocument(CreditSupportDocument creditSupportDocument);
		MasterAgreement.MasterAgreementBuilder setCreditSupportProvider(CreditSupportProvider creditSupportProvider);
		MasterAgreement.MasterAgreementBuilder addSpecifiedEntities(SpecifiedEntities specifiedEntities);
		MasterAgreement.MasterAgreementBuilder addSpecifiedEntities(SpecifiedEntities specifiedEntities, int idx);
		MasterAgreement.MasterAgreementBuilder addSpecifiedEntities(List<? extends SpecifiedEntities> specifiedEntities);
		MasterAgreement.MasterAgreementBuilder setSpecifiedEntities(List<? extends SpecifiedEntities> specifiedEntities);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("automaticEarlyTermination"), processor, AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder.class, getAutomaticEarlyTermination());
			processRosetta(path.newSubPath("terminationCurrency"), processor, TerminationCurrency.TerminationCurrencyBuilder.class, getTerminationCurrency());
			processRosetta(path.newSubPath("addressForNotices"), processor, AddressForNotices.AddressForNoticesBuilder.class, getAddressForNotices());
			processor.processBasic(path.newSubPath("nonContractualObligations"), Boolean.class, getNonContractualObligations(), this);
			processRosetta(path.newSubPath("creditSupportDocument"), processor, CreditSupportDocument.CreditSupportDocumentBuilder.class, getCreditSupportDocument());
			processRosetta(path.newSubPath("creditSupportProvider"), processor, CreditSupportProvider.CreditSupportProviderBuilder.class, getCreditSupportProvider());
			processRosetta(path.newSubPath("specifiedEntities"), processor, SpecifiedEntities.SpecifiedEntitiesBuilder.class, getSpecifiedEntities());
		}
		

		MasterAgreement.MasterAgreementBuilder prune();
	}

	/*********************** Immutable Implementation of MasterAgreement  ***********************/
	class MasterAgreementImpl extends MasterAgreementBase.MasterAgreementBaseImpl implements MasterAgreement {
		private final AutomaticEarlyTermination automaticEarlyTermination;
		private final TerminationCurrency terminationCurrency;
		private final AddressForNotices addressForNotices;
		private final Boolean nonContractualObligations;
		private final CreditSupportDocument creditSupportDocument;
		private final CreditSupportProvider creditSupportProvider;
		private final List<? extends SpecifiedEntities> specifiedEntities;
		
		protected MasterAgreementImpl(MasterAgreement.MasterAgreementBuilder builder) {
			super(builder);
			this.automaticEarlyTermination = ofNullable(builder.getAutomaticEarlyTermination()).map(f->f.build()).orElse(null);
			this.terminationCurrency = ofNullable(builder.getTerminationCurrency()).map(f->f.build()).orElse(null);
			this.addressForNotices = ofNullable(builder.getAddressForNotices()).map(f->f.build()).orElse(null);
			this.nonContractualObligations = builder.getNonContractualObligations();
			this.creditSupportDocument = ofNullable(builder.getCreditSupportDocument()).map(f->f.build()).orElse(null);
			this.creditSupportProvider = ofNullable(builder.getCreditSupportProvider()).map(f->f.build()).orElse(null);
			this.specifiedEntities = ofNullable(builder.getSpecifiedEntities()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("automaticEarlyTermination")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("automaticEarlyTermination")
		public AutomaticEarlyTermination getAutomaticEarlyTermination() {
			return automaticEarlyTermination;
		}
		
		@Override
		@RosettaAttribute("terminationCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("terminationCurrency")
		public TerminationCurrency getTerminationCurrency() {
			return terminationCurrency;
		}
		
		@Override
		@RosettaAttribute("addressForNotices")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("addressForNotices")
		public AddressForNotices getAddressForNotices() {
			return addressForNotices;
		}
		
		@Override
		@RosettaAttribute("nonContractualObligations")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nonContractualObligations")
		public Boolean getNonContractualObligations() {
			return nonContractualObligations;
		}
		
		@Override
		@RosettaAttribute("creditSupportDocument")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("creditSupportDocument")
		public CreditSupportDocument getCreditSupportDocument() {
			return creditSupportDocument;
		}
		
		@Override
		@RosettaAttribute("creditSupportProvider")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("creditSupportProvider")
		public CreditSupportProvider getCreditSupportProvider() {
			return creditSupportProvider;
		}
		
		@Override
		@RosettaAttribute("specifiedEntities")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("specifiedEntities")
		public List<? extends SpecifiedEntities> getSpecifiedEntities() {
			return specifiedEntities;
		}
		
		@Override
		public MasterAgreement build() {
			return this;
		}
		
		@Override
		public MasterAgreement.MasterAgreementBuilder toBuilder() {
			MasterAgreement.MasterAgreementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MasterAgreement.MasterAgreementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAutomaticEarlyTermination()).ifPresent(builder::setAutomaticEarlyTermination);
			ofNullable(getTerminationCurrency()).ifPresent(builder::setTerminationCurrency);
			ofNullable(getAddressForNotices()).ifPresent(builder::setAddressForNotices);
			ofNullable(getNonContractualObligations()).ifPresent(builder::setNonContractualObligations);
			ofNullable(getCreditSupportDocument()).ifPresent(builder::setCreditSupportDocument);
			ofNullable(getCreditSupportProvider()).ifPresent(builder::setCreditSupportProvider);
			ofNullable(getSpecifiedEntities()).ifPresent(builder::setSpecifiedEntities);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MasterAgreement _that = getType().cast(o);
		
			if (!Objects.equals(automaticEarlyTermination, _that.getAutomaticEarlyTermination())) return false;
			if (!Objects.equals(terminationCurrency, _that.getTerminationCurrency())) return false;
			if (!Objects.equals(addressForNotices, _that.getAddressForNotices())) return false;
			if (!Objects.equals(nonContractualObligations, _that.getNonContractualObligations())) return false;
			if (!Objects.equals(creditSupportDocument, _that.getCreditSupportDocument())) return false;
			if (!Objects.equals(creditSupportProvider, _that.getCreditSupportProvider())) return false;
			if (!ListEquals.listEquals(specifiedEntities, _that.getSpecifiedEntities())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (automaticEarlyTermination != null ? automaticEarlyTermination.hashCode() : 0);
			_result = 31 * _result + (terminationCurrency != null ? terminationCurrency.hashCode() : 0);
			_result = 31 * _result + (addressForNotices != null ? addressForNotices.hashCode() : 0);
			_result = 31 * _result + (nonContractualObligations != null ? nonContractualObligations.hashCode() : 0);
			_result = 31 * _result + (creditSupportDocument != null ? creditSupportDocument.hashCode() : 0);
			_result = 31 * _result + (creditSupportProvider != null ? creditSupportProvider.hashCode() : 0);
			_result = 31 * _result + (specifiedEntities != null ? specifiedEntities.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreement {" +
				"automaticEarlyTermination=" + this.automaticEarlyTermination + ", " +
				"terminationCurrency=" + this.terminationCurrency + ", " +
				"addressForNotices=" + this.addressForNotices + ", " +
				"nonContractualObligations=" + this.nonContractualObligations + ", " +
				"creditSupportDocument=" + this.creditSupportDocument + ", " +
				"creditSupportProvider=" + this.creditSupportProvider + ", " +
				"specifiedEntities=" + this.specifiedEntities +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MasterAgreement  ***********************/
	class MasterAgreementBuilderImpl extends MasterAgreementBase.MasterAgreementBaseBuilderImpl implements MasterAgreement.MasterAgreementBuilder {
	
		protected AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder automaticEarlyTermination;
		protected TerminationCurrency.TerminationCurrencyBuilder terminationCurrency;
		protected AddressForNotices.AddressForNoticesBuilder addressForNotices;
		protected Boolean nonContractualObligations;
		protected CreditSupportDocument.CreditSupportDocumentBuilder creditSupportDocument;
		protected CreditSupportProvider.CreditSupportProviderBuilder creditSupportProvider;
		protected List<SpecifiedEntities.SpecifiedEntitiesBuilder> specifiedEntities = new ArrayList<>();
		
		@Override
		@RosettaAttribute("automaticEarlyTermination")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("automaticEarlyTermination")
		public AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder getAutomaticEarlyTermination() {
			return automaticEarlyTermination;
		}
		
		@Override
		public AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder getOrCreateAutomaticEarlyTermination() {
			AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder result;
			if (automaticEarlyTermination!=null) {
				result = automaticEarlyTermination;
			}
			else {
				result = automaticEarlyTermination = AutomaticEarlyTermination.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("terminationCurrency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("terminationCurrency")
		public TerminationCurrency.TerminationCurrencyBuilder getTerminationCurrency() {
			return terminationCurrency;
		}
		
		@Override
		public TerminationCurrency.TerminationCurrencyBuilder getOrCreateTerminationCurrency() {
			TerminationCurrency.TerminationCurrencyBuilder result;
			if (terminationCurrency!=null) {
				result = terminationCurrency;
			}
			else {
				result = terminationCurrency = TerminationCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("addressForNotices")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("addressForNotices")
		public AddressForNotices.AddressForNoticesBuilder getAddressForNotices() {
			return addressForNotices;
		}
		
		@Override
		public AddressForNotices.AddressForNoticesBuilder getOrCreateAddressForNotices() {
			AddressForNotices.AddressForNoticesBuilder result;
			if (addressForNotices!=null) {
				result = addressForNotices;
			}
			else {
				result = addressForNotices = AddressForNotices.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nonContractualObligations")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("nonContractualObligations")
		public Boolean getNonContractualObligations() {
			return nonContractualObligations;
		}
		
		@Override
		@RosettaAttribute("creditSupportDocument")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("creditSupportDocument")
		public CreditSupportDocument.CreditSupportDocumentBuilder getCreditSupportDocument() {
			return creditSupportDocument;
		}
		
		@Override
		public CreditSupportDocument.CreditSupportDocumentBuilder getOrCreateCreditSupportDocument() {
			CreditSupportDocument.CreditSupportDocumentBuilder result;
			if (creditSupportDocument!=null) {
				result = creditSupportDocument;
			}
			else {
				result = creditSupportDocument = CreditSupportDocument.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("creditSupportProvider")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("creditSupportProvider")
		public CreditSupportProvider.CreditSupportProviderBuilder getCreditSupportProvider() {
			return creditSupportProvider;
		}
		
		@Override
		public CreditSupportProvider.CreditSupportProviderBuilder getOrCreateCreditSupportProvider() {
			CreditSupportProvider.CreditSupportProviderBuilder result;
			if (creditSupportProvider!=null) {
				result = creditSupportProvider;
			}
			else {
				result = creditSupportProvider = CreditSupportProvider.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("specifiedEntities")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("specifiedEntities")
		public List<? extends SpecifiedEntities.SpecifiedEntitiesBuilder> getSpecifiedEntities() {
			return specifiedEntities;
		}
		
		@Override
		public SpecifiedEntities.SpecifiedEntitiesBuilder getOrCreateSpecifiedEntities(int index) {
			if (specifiedEntities==null) {
				this.specifiedEntities = new ArrayList<>();
			}
			return getIndex(specifiedEntities, index, () -> {
						SpecifiedEntities.SpecifiedEntitiesBuilder newSpecifiedEntities = SpecifiedEntities.builder();
						return newSpecifiedEntities;
					});
		}
		
		@RosettaAttribute("automaticEarlyTermination")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("automaticEarlyTermination")
		@Override
		public MasterAgreement.MasterAgreementBuilder setAutomaticEarlyTermination(AutomaticEarlyTermination _automaticEarlyTermination) {
			this.automaticEarlyTermination = _automaticEarlyTermination == null ? null : _automaticEarlyTermination.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminationCurrency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("terminationCurrency")
		@Override
		public MasterAgreement.MasterAgreementBuilder setTerminationCurrency(TerminationCurrency _terminationCurrency) {
			this.terminationCurrency = _terminationCurrency == null ? null : _terminationCurrency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("addressForNotices")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("addressForNotices")
		@Override
		public MasterAgreement.MasterAgreementBuilder setAddressForNotices(AddressForNotices _addressForNotices) {
			this.addressForNotices = _addressForNotices == null ? null : _addressForNotices.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nonContractualObligations")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("nonContractualObligations")
		@Override
		public MasterAgreement.MasterAgreementBuilder setNonContractualObligations(Boolean _nonContractualObligations) {
			this.nonContractualObligations = _nonContractualObligations == null ? null : _nonContractualObligations;
			return this;
		}
		
		@RosettaAttribute("creditSupportDocument")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("creditSupportDocument")
		@Override
		public MasterAgreement.MasterAgreementBuilder setCreditSupportDocument(CreditSupportDocument _creditSupportDocument) {
			this.creditSupportDocument = _creditSupportDocument == null ? null : _creditSupportDocument.toBuilder();
			return this;
		}
		
		@RosettaAttribute("creditSupportProvider")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("creditSupportProvider")
		@Override
		public MasterAgreement.MasterAgreementBuilder setCreditSupportProvider(CreditSupportProvider _creditSupportProvider) {
			this.creditSupportProvider = _creditSupportProvider == null ? null : _creditSupportProvider.toBuilder();
			return this;
		}
		
		@RosettaAttribute("specifiedEntities")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("specifiedEntities")
		@Override
		public MasterAgreement.MasterAgreementBuilder addSpecifiedEntities(SpecifiedEntities _specifiedEntities) {
			if (_specifiedEntities != null) {
				this.specifiedEntities.add(_specifiedEntities.toBuilder());
			}
			return this;
		}
		
		@Override
		public MasterAgreement.MasterAgreementBuilder addSpecifiedEntities(SpecifiedEntities _specifiedEntities, int idx) {
			getIndex(this.specifiedEntities, idx, () -> _specifiedEntities.toBuilder());
			return this;
		}
		
		@Override
		public MasterAgreement.MasterAgreementBuilder addSpecifiedEntities(List<? extends SpecifiedEntities> specifiedEntitiess) {
			if (specifiedEntitiess != null) {
				for (final SpecifiedEntities toAdd : specifiedEntitiess) {
					this.specifiedEntities.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("specifiedEntities")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("specifiedEntities")
		@Override
		public MasterAgreement.MasterAgreementBuilder setSpecifiedEntities(List<? extends SpecifiedEntities> specifiedEntitiess) {
			if (specifiedEntitiess == null) {
				this.specifiedEntities = new ArrayList<>();
			} else {
				this.specifiedEntities = specifiedEntitiess.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public MasterAgreement build() {
			return new MasterAgreement.MasterAgreementImpl(this);
		}
		
		@Override
		public MasterAgreement.MasterAgreementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreement.MasterAgreementBuilder prune() {
			super.prune();
			if (automaticEarlyTermination!=null && !automaticEarlyTermination.prune().hasData()) automaticEarlyTermination = null;
			if (terminationCurrency!=null && !terminationCurrency.prune().hasData()) terminationCurrency = null;
			if (addressForNotices!=null && !addressForNotices.prune().hasData()) addressForNotices = null;
			if (creditSupportDocument!=null && !creditSupportDocument.prune().hasData()) creditSupportDocument = null;
			if (creditSupportProvider!=null && !creditSupportProvider.prune().hasData()) creditSupportProvider = null;
			specifiedEntities = specifiedEntities.stream().filter(b->b!=null).<SpecifiedEntities.SpecifiedEntitiesBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAutomaticEarlyTermination()!=null && getAutomaticEarlyTermination().hasData()) return true;
			if (getTerminationCurrency()!=null && getTerminationCurrency().hasData()) return true;
			if (getAddressForNotices()!=null && getAddressForNotices().hasData()) return true;
			if (getNonContractualObligations()!=null) return true;
			if (getCreditSupportDocument()!=null && getCreditSupportDocument().hasData()) return true;
			if (getCreditSupportProvider()!=null && getCreditSupportProvider().hasData()) return true;
			if (getSpecifiedEntities()!=null && getSpecifiedEntities().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreement.MasterAgreementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			MasterAgreement.MasterAgreementBuilder o = (MasterAgreement.MasterAgreementBuilder) other;
			
			merger.mergeRosetta(getAutomaticEarlyTermination(), o.getAutomaticEarlyTermination(), this::setAutomaticEarlyTermination);
			merger.mergeRosetta(getTerminationCurrency(), o.getTerminationCurrency(), this::setTerminationCurrency);
			merger.mergeRosetta(getAddressForNotices(), o.getAddressForNotices(), this::setAddressForNotices);
			merger.mergeRosetta(getCreditSupportDocument(), o.getCreditSupportDocument(), this::setCreditSupportDocument);
			merger.mergeRosetta(getCreditSupportProvider(), o.getCreditSupportProvider(), this::setCreditSupportProvider);
			merger.mergeRosetta(getSpecifiedEntities(), o.getSpecifiedEntities(), this::getOrCreateSpecifiedEntities);
			
			merger.mergeBasic(getNonContractualObligations(), o.getNonContractualObligations(), this::setNonContractualObligations);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MasterAgreement _that = getType().cast(o);
		
			if (!Objects.equals(automaticEarlyTermination, _that.getAutomaticEarlyTermination())) return false;
			if (!Objects.equals(terminationCurrency, _that.getTerminationCurrency())) return false;
			if (!Objects.equals(addressForNotices, _that.getAddressForNotices())) return false;
			if (!Objects.equals(nonContractualObligations, _that.getNonContractualObligations())) return false;
			if (!Objects.equals(creditSupportDocument, _that.getCreditSupportDocument())) return false;
			if (!Objects.equals(creditSupportProvider, _that.getCreditSupportProvider())) return false;
			if (!ListEquals.listEquals(specifiedEntities, _that.getSpecifiedEntities())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (automaticEarlyTermination != null ? automaticEarlyTermination.hashCode() : 0);
			_result = 31 * _result + (terminationCurrency != null ? terminationCurrency.hashCode() : 0);
			_result = 31 * _result + (addressForNotices != null ? addressForNotices.hashCode() : 0);
			_result = 31 * _result + (nonContractualObligations != null ? nonContractualObligations.hashCode() : 0);
			_result = 31 * _result + (creditSupportDocument != null ? creditSupportDocument.hashCode() : 0);
			_result = 31 * _result + (creditSupportProvider != null ? creditSupportProvider.hashCode() : 0);
			_result = 31 * _result + (specifiedEntities != null ? specifiedEntities.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreementBuilder {" +
				"automaticEarlyTermination=" + this.automaticEarlyTermination + ", " +
				"terminationCurrency=" + this.terminationCurrency + ", " +
				"addressForNotices=" + this.addressForNotices + ", " +
				"nonContractualObligations=" + this.nonContractualObligations + ", " +
				"creditSupportDocument=" + this.creditSupportDocument + ", " +
				"creditSupportProvider=" + this.creditSupportProvider + ", " +
				"specifiedEntities=" + this.specifiedEntities +
			'}' + " " + super.toString();
		}
	}
}
