package fpml.consolidated.business.events;

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
import fpml.consolidated.business.events.meta.WithdrawalPartyTradeInformationMeta;
import fpml.consolidated.doc.ReportingRegimeIdentifier;
import fpml.consolidated.doc.TradeCategory;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.RelatedParty;
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
 * Provision A type defining party-specific additional information that may be recorded against a trade, for withdrawal purposes.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining party-specific additional information that may be recorded against a trade, for withdrawal purposes.
 *
 */
@RosettaDataType(value="WithdrawalPartyTradeInformation", builder=WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="WithdrawalPartyTradeInformation", model="fpml", builder=WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilderImpl.class, version="2.1.1")
public interface WithdrawalPartyTradeInformation extends RosettaModelObject {

	WithdrawalPartyTradeInformationMeta metaData = new WithdrawalPartyTradeInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to a party.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to a party.
	 *
	 */
	PartyReference getPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to an account.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to an account.
	 *
	 */
	AccountReference getAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This may be used to identify one or more parties that perform a role within the transaction. If this is within a partyTradeInformation block, the related party performs the role with respect to the party identifie by the "partyReference" in the partyTradeInformation block.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This may be used to identify one or more parties that perform a role within the transaction. If this is within a partyTradeInformation block, the related party performs the role with respect to the party identifie by the "partyReference" in the partyTradeInformation block.
	 *
	 */
	List<? extends RelatedParty> getRelatedParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Used to categorize trades into user-defined categories, such as house trades vs. customer trades.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Used to categorize trades into user-defined categories, such as house trades vs. customer trades.
	 *
	 */
	List<? extends TradeCategory> getCategory();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Allows the organization to specify which if any relevant regulators or other supervisory bodies this is relevant for, and what reporting rules apply.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Allows the organization to specify which if any relevant regulators or other supervisory bodies this is relevant for, and what reporting rules apply.
	 *
	 */
	List<? extends ReportingRegimeIdentifier> getReportingRegime();

	/*********************** Build Methods  ***********************/
	WithdrawalPartyTradeInformation build();
	
	WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder toBuilder();
	
	static WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder builder() {
		return new WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WithdrawalPartyTradeInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends WithdrawalPartyTradeInformation> getType() {
		return WithdrawalPartyTradeInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("accountReference"), processor, AccountReference.class, getAccountReference());
		processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.class, getRelatedParty());
		processRosetta(path.newSubPath("category"), processor, TradeCategory.class, getCategory());
		processRosetta(path.newSubPath("reportingRegime"), processor, ReportingRegimeIdentifier.class, getReportingRegime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface WithdrawalPartyTradeInformationBuilder extends WithdrawalPartyTradeInformation, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getAccountReference();
		RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index);
		@Override
		List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty();
		TradeCategory.TradeCategoryBuilder getOrCreateCategory(int index);
		@Override
		List<? extends TradeCategory.TradeCategoryBuilder> getCategory();
		ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder getOrCreateReportingRegime(int index);
		@Override
		List<? extends ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder> getReportingRegime();
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder setPartyReference(PartyReference partyReference);
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder setAccountReference(AccountReference accountReference);
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addRelatedParty(RelatedParty relatedParty);
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addRelatedParty(RelatedParty relatedParty, int idx);
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addRelatedParty(List<? extends RelatedParty> relatedParty);
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder setRelatedParty(List<? extends RelatedParty> relatedParty);
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addCategory(TradeCategory category);
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addCategory(TradeCategory category, int idx);
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addCategory(List<? extends TradeCategory> category);
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder setCategory(List<? extends TradeCategory> category);
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addReportingRegime(ReportingRegimeIdentifier reportingRegime);
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addReportingRegime(ReportingRegimeIdentifier reportingRegime, int idx);
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addReportingRegime(List<? extends ReportingRegimeIdentifier> reportingRegime);
		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder setReportingRegime(List<? extends ReportingRegimeIdentifier> reportingRegime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("accountReference"), processor, AccountReference.AccountReferenceBuilder.class, getAccountReference());
			processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.RelatedPartyBuilder.class, getRelatedParty());
			processRosetta(path.newSubPath("category"), processor, TradeCategory.TradeCategoryBuilder.class, getCategory());
			processRosetta(path.newSubPath("reportingRegime"), processor, ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder.class, getReportingRegime());
		}
		

		WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder prune();
	}

	/*********************** Immutable Implementation of WithdrawalPartyTradeInformation  ***********************/
	class WithdrawalPartyTradeInformationImpl implements WithdrawalPartyTradeInformation {
		private final PartyReference partyReference;
		private final AccountReference accountReference;
		private final List<? extends RelatedParty> relatedParty;
		private final List<? extends TradeCategory> category;
		private final List<? extends ReportingRegimeIdentifier> reportingRegime;
		
		protected WithdrawalPartyTradeInformationImpl(WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.accountReference = ofNullable(builder.getAccountReference()).map(f->f.build()).orElse(null);
			this.relatedParty = ofNullable(builder.getRelatedParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.category = ofNullable(builder.getCategory()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.reportingRegime = ofNullable(builder.getReportingRegime()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountReference")
		public AccountReference getAccountReference() {
			return accountReference;
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedParty")
		public List<? extends RelatedParty> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		@RosettaAttribute("category")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("category")
		public List<? extends TradeCategory> getCategory() {
			return category;
		}
		
		@Override
		@RosettaAttribute("reportingRegime")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reportingRegime")
		public List<? extends ReportingRegimeIdentifier> getReportingRegime() {
			return reportingRegime;
		}
		
		@Override
		public WithdrawalPartyTradeInformation build() {
			return this;
		}
		
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder toBuilder() {
			WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getAccountReference()).ifPresent(builder::setAccountReference);
			ofNullable(getRelatedParty()).ifPresent(builder::setRelatedParty);
			ofNullable(getCategory()).ifPresent(builder::setCategory);
			ofNullable(getReportingRegime()).ifPresent(builder::setReportingRegime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WithdrawalPartyTradeInformation _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(accountReference, _that.getAccountReference())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!ListEquals.listEquals(category, _that.getCategory())) return false;
			if (!ListEquals.listEquals(reportingRegime, _that.getReportingRegime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (category != null ? category.hashCode() : 0);
			_result = 31 * _result + (reportingRegime != null ? reportingRegime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WithdrawalPartyTradeInformation {" +
				"partyReference=" + this.partyReference + ", " +
				"accountReference=" + this.accountReference + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"category=" + this.category + ", " +
				"reportingRegime=" + this.reportingRegime +
			'}';
		}
	}

	/*********************** Builder Implementation of WithdrawalPartyTradeInformation  ***********************/
	class WithdrawalPartyTradeInformationBuilderImpl implements WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder {
	
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected AccountReference.AccountReferenceBuilder accountReference;
		protected List<RelatedParty.RelatedPartyBuilder> relatedParty = new ArrayList<>();
		protected List<TradeCategory.TradeCategoryBuilder> category = new ArrayList<>();
		protected List<ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder> reportingRegime = new ArrayList<>();
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public PartyReference.PartyReferenceBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountReference")
		public AccountReference.AccountReferenceBuilder getAccountReference() {
			return accountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (accountReference!=null) {
				result = accountReference;
			}
			else {
				result = accountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relatedParty")
		public List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		public RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index) {
			if (relatedParty==null) {
				this.relatedParty = new ArrayList<>();
			}
			return getIndex(relatedParty, index, () -> {
						RelatedParty.RelatedPartyBuilder newRelatedParty = RelatedParty.builder();
						return newRelatedParty;
					});
		}
		
		@Override
		@RosettaAttribute("category")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("category")
		public List<? extends TradeCategory.TradeCategoryBuilder> getCategory() {
			return category;
		}
		
		@Override
		public TradeCategory.TradeCategoryBuilder getOrCreateCategory(int index) {
			if (category==null) {
				this.category = new ArrayList<>();
			}
			return getIndex(category, index, () -> {
						TradeCategory.TradeCategoryBuilder newCategory = TradeCategory.builder();
						return newCategory;
					});
		}
		
		@Override
		@RosettaAttribute("reportingRegime")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reportingRegime")
		public List<? extends ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder> getReportingRegime() {
			return reportingRegime;
		}
		
		@Override
		public ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder getOrCreateReportingRegime(int index) {
			if (reportingRegime==null) {
				this.reportingRegime = new ArrayList<>();
			}
			return getIndex(reportingRegime, index, () -> {
						ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder newReportingRegime = ReportingRegimeIdentifier.builder();
						return newReportingRegime;
					});
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accountReference")
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder setAccountReference(AccountReference _accountReference) {
			this.accountReference = _accountReference == null ? null : _accountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addRelatedParty(RelatedParty _relatedParty) {
			if (_relatedParty != null) {
				this.relatedParty.add(_relatedParty.toBuilder());
			}
			return this;
		}
		
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addRelatedParty(RelatedParty _relatedParty, int idx) {
			getIndex(this.relatedParty, idx, () -> _relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys != null) {
				for (final RelatedParty toAdd : relatedPartys) {
					this.relatedParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys == null) {
				this.relatedParty = new ArrayList<>();
			} else {
				this.relatedParty = relatedPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("category")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("category")
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addCategory(TradeCategory _category) {
			if (_category != null) {
				this.category.add(_category.toBuilder());
			}
			return this;
		}
		
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addCategory(TradeCategory _category, int idx) {
			getIndex(this.category, idx, () -> _category.toBuilder());
			return this;
		}
		
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addCategory(List<? extends TradeCategory> categorys) {
			if (categorys != null) {
				for (final TradeCategory toAdd : categorys) {
					this.category.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("category")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("category")
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder setCategory(List<? extends TradeCategory> categorys) {
			if (categorys == null) {
				this.category = new ArrayList<>();
			} else {
				this.category = categorys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("reportingRegime")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reportingRegime")
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addReportingRegime(ReportingRegimeIdentifier _reportingRegime) {
			if (_reportingRegime != null) {
				this.reportingRegime.add(_reportingRegime.toBuilder());
			}
			return this;
		}
		
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addReportingRegime(ReportingRegimeIdentifier _reportingRegime, int idx) {
			getIndex(this.reportingRegime, idx, () -> _reportingRegime.toBuilder());
			return this;
		}
		
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder addReportingRegime(List<? extends ReportingRegimeIdentifier> reportingRegimes) {
			if (reportingRegimes != null) {
				for (final ReportingRegimeIdentifier toAdd : reportingRegimes) {
					this.reportingRegime.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("reportingRegime")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("reportingRegime")
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder setReportingRegime(List<? extends ReportingRegimeIdentifier> reportingRegimes) {
			if (reportingRegimes == null) {
				this.reportingRegime = new ArrayList<>();
			} else {
				this.reportingRegime = reportingRegimes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public WithdrawalPartyTradeInformation build() {
			return new WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationImpl(this);
		}
		
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (accountReference!=null && !accountReference.prune().hasData()) accountReference = null;
			relatedParty = relatedParty.stream().filter(b->b!=null).<RelatedParty.RelatedPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			category = category.stream().filter(b->b!=null).<TradeCategory.TradeCategoryBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			reportingRegime = reportingRegime.stream().filter(b->b!=null).<ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getAccountReference()!=null && getAccountReference().hasData()) return true;
			if (getRelatedParty()!=null && getRelatedParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCategory()!=null && getCategory().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReportingRegime()!=null && getReportingRegime().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder o = (WithdrawalPartyTradeInformation.WithdrawalPartyTradeInformationBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getAccountReference(), o.getAccountReference(), this::setAccountReference);
			merger.mergeRosetta(getRelatedParty(), o.getRelatedParty(), this::getOrCreateRelatedParty);
			merger.mergeRosetta(getCategory(), o.getCategory(), this::getOrCreateCategory);
			merger.mergeRosetta(getReportingRegime(), o.getReportingRegime(), this::getOrCreateReportingRegime);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WithdrawalPartyTradeInformation _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(accountReference, _that.getAccountReference())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!ListEquals.listEquals(category, _that.getCategory())) return false;
			if (!ListEquals.listEquals(reportingRegime, _that.getReportingRegime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (category != null ? category.hashCode() : 0);
			_result = 31 * _result + (reportingRegime != null ? reportingRegime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WithdrawalPartyTradeInformationBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"accountReference=" + this.accountReference + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"category=" + this.category + ", " +
				"reportingRegime=" + this.reportingRegime +
			'}';
		}
	}
}
