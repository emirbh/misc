package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.PartyTradeInformationSimpleMeta;
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
 * Provision A type defining party-specific additional information that may be recorded against a trade.
 *
 */
@RosettaDataType(value="PartyTradeInformationSimple", builder=PartyTradeInformationSimple.PartyTradeInformationSimpleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PartyTradeInformationSimple", model="fpml", builder=PartyTradeInformationSimple.PartyTradeInformationSimpleBuilderImpl.class, version="2.1.1")
public interface PartyTradeInformationSimple extends RosettaModelObject {

	PartyTradeInformationSimpleMeta metaData = new PartyTradeInformationSimpleMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
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
	 */
	List<? extends RelatedParty> getRelatedParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Allows the organization to specify which if any relevant regulators or other supervisory bodies this is relevant for, and what reporting rules apply.
	 *
	 */
	List<? extends ReportingRegimeIdentifier> getReportingRegime();

	/*********************** Build Methods  ***********************/
	PartyTradeInformationSimple build();
	
	PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder toBuilder();
	
	static PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder builder() {
		return new PartyTradeInformationSimple.PartyTradeInformationSimpleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyTradeInformationSimple> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartyTradeInformationSimple> getType() {
		return PartyTradeInformationSimple.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("accountReference"), processor, AccountReference.class, getAccountReference());
		processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.class, getRelatedParty());
		processRosetta(path.newSubPath("reportingRegime"), processor, ReportingRegimeIdentifier.class, getReportingRegime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyTradeInformationSimpleBuilder extends PartyTradeInformationSimple, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getAccountReference();
		RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int index);
		@Override
		List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty();
		ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder getOrCreateReportingRegime(int index);
		@Override
		List<? extends ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder> getReportingRegime();
		PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder setPartyReference(PartyReference partyReference);
		PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder setAccountReference(AccountReference accountReference);
		PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder addRelatedParty(RelatedParty relatedParty);
		PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder addRelatedParty(RelatedParty relatedParty, int idx);
		PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder addRelatedParty(List<? extends RelatedParty> relatedParty);
		PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder setRelatedParty(List<? extends RelatedParty> relatedParty);
		PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder addReportingRegime(ReportingRegimeIdentifier reportingRegime);
		PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder addReportingRegime(ReportingRegimeIdentifier reportingRegime, int idx);
		PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder addReportingRegime(List<? extends ReportingRegimeIdentifier> reportingRegime);
		PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder setReportingRegime(List<? extends ReportingRegimeIdentifier> reportingRegime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("accountReference"), processor, AccountReference.AccountReferenceBuilder.class, getAccountReference());
			processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.RelatedPartyBuilder.class, getRelatedParty());
			processRosetta(path.newSubPath("reportingRegime"), processor, ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder.class, getReportingRegime());
		}
		

		PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder prune();
	}

	/*********************** Immutable Implementation of PartyTradeInformationSimple  ***********************/
	class PartyTradeInformationSimpleImpl implements PartyTradeInformationSimple {
		private final PartyReference partyReference;
		private final AccountReference accountReference;
		private final List<? extends RelatedParty> relatedParty;
		private final List<? extends ReportingRegimeIdentifier> reportingRegime;
		
		protected PartyTradeInformationSimpleImpl(PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.accountReference = ofNullable(builder.getAccountReference()).map(f->f.build()).orElse(null);
			this.relatedParty = ofNullable(builder.getRelatedParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		@RosettaAttribute("reportingRegime")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reportingRegime")
		public List<? extends ReportingRegimeIdentifier> getReportingRegime() {
			return reportingRegime;
		}
		
		@Override
		public PartyTradeInformationSimple build() {
			return this;
		}
		
		@Override
		public PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder toBuilder() {
			PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getAccountReference()).ifPresent(builder::setAccountReference);
			ofNullable(getRelatedParty()).ifPresent(builder::setRelatedParty);
			ofNullable(getReportingRegime()).ifPresent(builder::setReportingRegime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyTradeInformationSimple _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(accountReference, _that.getAccountReference())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!ListEquals.listEquals(reportingRegime, _that.getReportingRegime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (reportingRegime != null ? reportingRegime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyTradeInformationSimple {" +
				"partyReference=" + this.partyReference + ", " +
				"accountReference=" + this.accountReference + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"reportingRegime=" + this.reportingRegime +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyTradeInformationSimple  ***********************/
	class PartyTradeInformationSimpleBuilderImpl implements PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder {
	
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected AccountReference.AccountReferenceBuilder accountReference;
		protected List<RelatedParty.RelatedPartyBuilder> relatedParty = new ArrayList<>();
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
		public PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accountReference")
		@Override
		public PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder setAccountReference(AccountReference _accountReference) {
			this.accountReference = _accountReference == null ? null : _accountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relatedParty")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relatedParty")
		@Override
		public PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder addRelatedParty(RelatedParty _relatedParty) {
			if (_relatedParty != null) {
				this.relatedParty.add(_relatedParty.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder addRelatedParty(RelatedParty _relatedParty, int idx) {
			getIndex(this.relatedParty, idx, () -> _relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
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
		public PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys == null) {
				this.relatedParty = new ArrayList<>();
			} else {
				this.relatedParty = relatedPartys.stream()
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
		public PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder addReportingRegime(ReportingRegimeIdentifier _reportingRegime) {
			if (_reportingRegime != null) {
				this.reportingRegime.add(_reportingRegime.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder addReportingRegime(ReportingRegimeIdentifier _reportingRegime, int idx) {
			getIndex(this.reportingRegime, idx, () -> _reportingRegime.toBuilder());
			return this;
		}
		
		@Override
		public PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder addReportingRegime(List<? extends ReportingRegimeIdentifier> reportingRegimes) {
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
		public PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder setReportingRegime(List<? extends ReportingRegimeIdentifier> reportingRegimes) {
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
		public PartyTradeInformationSimple build() {
			return new PartyTradeInformationSimple.PartyTradeInformationSimpleImpl(this);
		}
		
		@Override
		public PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (accountReference!=null && !accountReference.prune().hasData()) accountReference = null;
			relatedParty = relatedParty.stream().filter(b->b!=null).<RelatedParty.RelatedPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			reportingRegime = reportingRegime.stream().filter(b->b!=null).<ReportingRegimeIdentifier.ReportingRegimeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getAccountReference()!=null && getAccountReference().hasData()) return true;
			if (getRelatedParty()!=null && getRelatedParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getReportingRegime()!=null && getReportingRegime().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder o = (PartyTradeInformationSimple.PartyTradeInformationSimpleBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getAccountReference(), o.getAccountReference(), this::setAccountReference);
			merger.mergeRosetta(getRelatedParty(), o.getRelatedParty(), this::getOrCreateRelatedParty);
			merger.mergeRosetta(getReportingRegime(), o.getReportingRegime(), this::getOrCreateReportingRegime);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyTradeInformationSimple _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(accountReference, _that.getAccountReference())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			if (!ListEquals.listEquals(reportingRegime, _that.getReportingRegime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			_result = 31 * _result + (reportingRegime != null ? reportingRegime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyTradeInformationSimpleBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"accountReference=" + this.accountReference + ", " +
				"relatedParty=" + this.relatedParty + ", " +
				"reportingRegime=" + this.reportingRegime +
			'}';
		}
	}
}
