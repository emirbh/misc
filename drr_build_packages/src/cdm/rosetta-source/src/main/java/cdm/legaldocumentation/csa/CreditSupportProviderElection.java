package cdm.legaldocumentation.csa;

import cdm.base.staticdata.party.LegalEntity;
import cdm.base.staticdata.party.Party;
import cdm.legaldocumentation.common.CreditSupportProviderTermsEnum;
import cdm.legaldocumentation.csa.meta.CreditSupportProviderElectionMeta;
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
@RosettaDataType(value="CreditSupportProviderElection", builder=CreditSupportProviderElection.CreditSupportProviderElectionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CreditSupportProviderElection", model="cdm", builder=CreditSupportProviderElection.CreditSupportProviderElectionBuilderImpl.class, version="6.23.0")
public interface CreditSupportProviderElection extends RosettaModelObject {

	CreditSupportProviderElectionMeta metaData = new CreditSupportProviderElectionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The elective party.
	 */
	Party getParty();
	/**
	 * Specification of the Credit Support Provider terms.
	 */
	CreditSupportProviderTermsEnum getCreditSupportProviderTerms();
	/**
	 * The specified Credit Support Provider(s), if any.
	 */
	List<? extends LegalEntity> getCreditSupportProvider();
	/**
	 * ...
	 */
	String getBespokeCreditSuppportProvider();

	/*********************** Build Methods  ***********************/
	CreditSupportProviderElection build();
	
	CreditSupportProviderElection.CreditSupportProviderElectionBuilder toBuilder();
	
	static CreditSupportProviderElection.CreditSupportProviderElectionBuilder builder() {
		return new CreditSupportProviderElection.CreditSupportProviderElectionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditSupportProviderElection> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CreditSupportProviderElection> getType() {
		return CreditSupportProviderElection.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processor.processBasic(path.newSubPath("creditSupportProviderTerms"), CreditSupportProviderTermsEnum.class, getCreditSupportProviderTerms(), this);
		processRosetta(path.newSubPath("creditSupportProvider"), processor, LegalEntity.class, getCreditSupportProvider());
		processor.processBasic(path.newSubPath("bespokeCreditSuppportProvider"), String.class, getBespokeCreditSuppportProvider(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditSupportProviderElectionBuilder extends CreditSupportProviderElection, RosettaModelObjectBuilder {
		Party.PartyBuilder getOrCreateParty();
		@Override
		Party.PartyBuilder getParty();
		LegalEntity.LegalEntityBuilder getOrCreateCreditSupportProvider(int index);
		@Override
		List<? extends LegalEntity.LegalEntityBuilder> getCreditSupportProvider();
		CreditSupportProviderElection.CreditSupportProviderElectionBuilder setParty(Party party);
		CreditSupportProviderElection.CreditSupportProviderElectionBuilder setCreditSupportProviderTerms(CreditSupportProviderTermsEnum creditSupportProviderTerms);
		CreditSupportProviderElection.CreditSupportProviderElectionBuilder addCreditSupportProvider(LegalEntity creditSupportProvider);
		CreditSupportProviderElection.CreditSupportProviderElectionBuilder addCreditSupportProvider(LegalEntity creditSupportProvider, int idx);
		CreditSupportProviderElection.CreditSupportProviderElectionBuilder addCreditSupportProvider(List<? extends LegalEntity> creditSupportProvider);
		CreditSupportProviderElection.CreditSupportProviderElectionBuilder setCreditSupportProvider(List<? extends LegalEntity> creditSupportProvider);
		CreditSupportProviderElection.CreditSupportProviderElectionBuilder setBespokeCreditSuppportProvider(String bespokeCreditSuppportProvider);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processor.processBasic(path.newSubPath("creditSupportProviderTerms"), CreditSupportProviderTermsEnum.class, getCreditSupportProviderTerms(), this);
			processRosetta(path.newSubPath("creditSupportProvider"), processor, LegalEntity.LegalEntityBuilder.class, getCreditSupportProvider());
			processor.processBasic(path.newSubPath("bespokeCreditSuppportProvider"), String.class, getBespokeCreditSuppportProvider(), this);
		}
		

		CreditSupportProviderElection.CreditSupportProviderElectionBuilder prune();
	}

	/*********************** Immutable Implementation of CreditSupportProviderElection  ***********************/
	class CreditSupportProviderElectionImpl implements CreditSupportProviderElection {
		private final Party party;
		private final CreditSupportProviderTermsEnum creditSupportProviderTerms;
		private final List<? extends LegalEntity> creditSupportProvider;
		private final String bespokeCreditSuppportProvider;
		
		protected CreditSupportProviderElectionImpl(CreditSupportProviderElection.CreditSupportProviderElectionBuilder builder) {
			this.party = ofNullable(builder.getParty()).map(f->f.build()).orElse(null);
			this.creditSupportProviderTerms = builder.getCreditSupportProviderTerms();
			this.creditSupportProvider = ofNullable(builder.getCreditSupportProvider()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.bespokeCreditSuppportProvider = builder.getBespokeCreditSuppportProvider();
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
		@RosettaAttribute("creditSupportProviderTerms")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("creditSupportProviderTerms")
		public CreditSupportProviderTermsEnum getCreditSupportProviderTerms() {
			return creditSupportProviderTerms;
		}
		
		@Override
		@RosettaAttribute("creditSupportProvider")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("creditSupportProvider")
		public List<? extends LegalEntity> getCreditSupportProvider() {
			return creditSupportProvider;
		}
		
		@Override
		@RosettaAttribute("bespokeCreditSuppportProvider")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bespokeCreditSuppportProvider")
		public String getBespokeCreditSuppportProvider() {
			return bespokeCreditSuppportProvider;
		}
		
		@Override
		public CreditSupportProviderElection build() {
			return this;
		}
		
		@Override
		public CreditSupportProviderElection.CreditSupportProviderElectionBuilder toBuilder() {
			CreditSupportProviderElection.CreditSupportProviderElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditSupportProviderElection.CreditSupportProviderElectionBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getCreditSupportProviderTerms()).ifPresent(builder::setCreditSupportProviderTerms);
			ofNullable(getCreditSupportProvider()).ifPresent(builder::setCreditSupportProvider);
			ofNullable(getBespokeCreditSuppportProvider()).ifPresent(builder::setBespokeCreditSuppportProvider);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportProviderElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(creditSupportProviderTerms, _that.getCreditSupportProviderTerms())) return false;
			if (!ListEquals.listEquals(creditSupportProvider, _that.getCreditSupportProvider())) return false;
			if (!Objects.equals(bespokeCreditSuppportProvider, _that.getBespokeCreditSuppportProvider())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (creditSupportProviderTerms != null ? creditSupportProviderTerms.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (creditSupportProvider != null ? creditSupportProvider.hashCode() : 0);
			_result = 31 * _result + (bespokeCreditSuppportProvider != null ? bespokeCreditSuppportProvider.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportProviderElection {" +
				"party=" + this.party + ", " +
				"creditSupportProviderTerms=" + this.creditSupportProviderTerms + ", " +
				"creditSupportProvider=" + this.creditSupportProvider + ", " +
				"bespokeCreditSuppportProvider=" + this.bespokeCreditSuppportProvider +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditSupportProviderElection  ***********************/
	class CreditSupportProviderElectionBuilderImpl implements CreditSupportProviderElection.CreditSupportProviderElectionBuilder {
	
		protected Party.PartyBuilder party;
		protected CreditSupportProviderTermsEnum creditSupportProviderTerms;
		protected List<LegalEntity.LegalEntityBuilder> creditSupportProvider = new ArrayList<>();
		protected String bespokeCreditSuppportProvider;
		
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
		@RosettaAttribute("creditSupportProviderTerms")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("creditSupportProviderTerms")
		public CreditSupportProviderTermsEnum getCreditSupportProviderTerms() {
			return creditSupportProviderTerms;
		}
		
		@Override
		@RosettaAttribute("creditSupportProvider")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("creditSupportProvider")
		public List<? extends LegalEntity.LegalEntityBuilder> getCreditSupportProvider() {
			return creditSupportProvider;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateCreditSupportProvider(int index) {
			if (creditSupportProvider==null) {
				this.creditSupportProvider = new ArrayList<>();
			}
			return getIndex(creditSupportProvider, index, () -> {
						LegalEntity.LegalEntityBuilder newCreditSupportProvider = LegalEntity.builder();
						return newCreditSupportProvider;
					});
		}
		
		@Override
		@RosettaAttribute("bespokeCreditSuppportProvider")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bespokeCreditSuppportProvider")
		public String getBespokeCreditSuppportProvider() {
			return bespokeCreditSuppportProvider;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public CreditSupportProviderElection.CreditSupportProviderElectionBuilder setParty(Party _party) {
			this.party = _party == null ? null : _party.toBuilder();
			return this;
		}
		
		@RosettaAttribute("creditSupportProviderTerms")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("creditSupportProviderTerms")
		@Override
		public CreditSupportProviderElection.CreditSupportProviderElectionBuilder setCreditSupportProviderTerms(CreditSupportProviderTermsEnum _creditSupportProviderTerms) {
			this.creditSupportProviderTerms = _creditSupportProviderTerms == null ? null : _creditSupportProviderTerms;
			return this;
		}
		
		@RosettaAttribute("creditSupportProvider")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("creditSupportProvider")
		@Override
		public CreditSupportProviderElection.CreditSupportProviderElectionBuilder addCreditSupportProvider(LegalEntity _creditSupportProvider) {
			if (_creditSupportProvider != null) {
				this.creditSupportProvider.add(_creditSupportProvider.toBuilder());
			}
			return this;
		}
		
		@Override
		public CreditSupportProviderElection.CreditSupportProviderElectionBuilder addCreditSupportProvider(LegalEntity _creditSupportProvider, int idx) {
			getIndex(this.creditSupportProvider, idx, () -> _creditSupportProvider.toBuilder());
			return this;
		}
		
		@Override
		public CreditSupportProviderElection.CreditSupportProviderElectionBuilder addCreditSupportProvider(List<? extends LegalEntity> creditSupportProviders) {
			if (creditSupportProviders != null) {
				for (final LegalEntity toAdd : creditSupportProviders) {
					this.creditSupportProvider.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("creditSupportProvider")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("creditSupportProvider")
		@Override
		public CreditSupportProviderElection.CreditSupportProviderElectionBuilder setCreditSupportProvider(List<? extends LegalEntity> creditSupportProviders) {
			if (creditSupportProviders == null) {
				this.creditSupportProvider = new ArrayList<>();
			} else {
				this.creditSupportProvider = creditSupportProviders.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("bespokeCreditSuppportProvider")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bespokeCreditSuppportProvider")
		@Override
		public CreditSupportProviderElection.CreditSupportProviderElectionBuilder setBespokeCreditSuppportProvider(String _bespokeCreditSuppportProvider) {
			this.bespokeCreditSuppportProvider = _bespokeCreditSuppportProvider == null ? null : _bespokeCreditSuppportProvider;
			return this;
		}
		
		@Override
		public CreditSupportProviderElection build() {
			return new CreditSupportProviderElection.CreditSupportProviderElectionImpl(this);
		}
		
		@Override
		public CreditSupportProviderElection.CreditSupportProviderElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportProviderElection.CreditSupportProviderElectionBuilder prune() {
			if (party!=null && !party.prune().hasData()) party = null;
			creditSupportProvider = creditSupportProvider.stream().filter(b->b!=null).<LegalEntity.LegalEntityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null && getParty().hasData()) return true;
			if (getCreditSupportProviderTerms()!=null) return true;
			if (getCreditSupportProvider()!=null && getCreditSupportProvider().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getBespokeCreditSuppportProvider()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportProviderElection.CreditSupportProviderElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditSupportProviderElection.CreditSupportProviderElectionBuilder o = (CreditSupportProviderElection.CreditSupportProviderElectionBuilder) other;
			
			merger.mergeRosetta(getParty(), o.getParty(), this::setParty);
			merger.mergeRosetta(getCreditSupportProvider(), o.getCreditSupportProvider(), this::getOrCreateCreditSupportProvider);
			
			merger.mergeBasic(getCreditSupportProviderTerms(), o.getCreditSupportProviderTerms(), this::setCreditSupportProviderTerms);
			merger.mergeBasic(getBespokeCreditSuppportProvider(), o.getBespokeCreditSuppportProvider(), this::setBespokeCreditSuppportProvider);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportProviderElection _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(creditSupportProviderTerms, _that.getCreditSupportProviderTerms())) return false;
			if (!ListEquals.listEquals(creditSupportProvider, _that.getCreditSupportProvider())) return false;
			if (!Objects.equals(bespokeCreditSuppportProvider, _that.getBespokeCreditSuppportProvider())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (creditSupportProviderTerms != null ? creditSupportProviderTerms.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (creditSupportProvider != null ? creditSupportProvider.hashCode() : 0);
			_result = 31 * _result + (bespokeCreditSuppportProvider != null ? bespokeCreditSuppportProvider.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportProviderElectionBuilder {" +
				"party=" + this.party + ", " +
				"creditSupportProviderTerms=" + this.creditSupportProviderTerms + ", " +
				"creditSupportProvider=" + this.creditSupportProvider + ", " +
				"bespokeCreditSuppportProvider=" + this.bespokeCreditSuppportProvider +
			'}';
		}
	}
}
