package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.TerminationCurrencyAmendmentMeta;
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
 * A class to specify the Amendment to Termination Currency elections by the parties to the agreement.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(t)" * name "Amendment to Termination Currency."
 *
 * Provision 
 *
 */
@RosettaDataType(value="TerminationCurrencyAmendment", builder=TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilderImpl.class, version="6.23.0")
@RuneDataType(value="TerminationCurrencyAmendment", model="cdm", builder=TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilderImpl.class, version="6.23.0")
public interface TerminationCurrencyAmendment extends RosettaModelObject {

	TerminationCurrencyAmendmentMeta metaData = new TerminationCurrencyAmendmentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The qualification of whether the Amendment to Termination Currency is deemed applicable by the parties (True) or not (False).
	 */
	Boolean getIsApplicable();
	/**
	 * The effective date of the Amendment to Termination Currency. This date can be specified as either an actual date, a specific date (e.g. the annex date) or as a custom provision.
	 */
	AmendmentEffectiveDate getEffectiveDate();
	/**
	 * The parties&#39; Amendment Currency election.
	 */
	List<? extends TerminationCurrencyElection> getPartyElection();

	/*********************** Build Methods  ***********************/
	TerminationCurrencyAmendment build();
	
	TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder toBuilder();
	
	static TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder builder() {
		return new TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TerminationCurrencyAmendment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TerminationCurrencyAmendment> getType() {
		return TerminationCurrencyAmendment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		processRosetta(path.newSubPath("effectiveDate"), processor, AmendmentEffectiveDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("partyElection"), processor, TerminationCurrencyElection.class, getPartyElection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TerminationCurrencyAmendmentBuilder extends TerminationCurrencyAmendment, RosettaModelObjectBuilder {
		AmendmentEffectiveDate.AmendmentEffectiveDateBuilder getOrCreateEffectiveDate();
		@Override
		AmendmentEffectiveDate.AmendmentEffectiveDateBuilder getEffectiveDate();
		TerminationCurrencyElection.TerminationCurrencyElectionBuilder getOrCreatePartyElection(int index);
		@Override
		List<? extends TerminationCurrencyElection.TerminationCurrencyElectionBuilder> getPartyElection();
		TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder setIsApplicable(Boolean isApplicable);
		TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder setEffectiveDate(AmendmentEffectiveDate effectiveDate);
		TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder addPartyElection(TerminationCurrencyElection partyElection);
		TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder addPartyElection(TerminationCurrencyElection partyElection, int idx);
		TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder addPartyElection(List<? extends TerminationCurrencyElection> partyElection);
		TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder setPartyElection(List<? extends TerminationCurrencyElection> partyElection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			processRosetta(path.newSubPath("effectiveDate"), processor, AmendmentEffectiveDate.AmendmentEffectiveDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("partyElection"), processor, TerminationCurrencyElection.TerminationCurrencyElectionBuilder.class, getPartyElection());
		}
		

		TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder prune();
	}

	/*********************** Immutable Implementation of TerminationCurrencyAmendment  ***********************/
	class TerminationCurrencyAmendmentImpl implements TerminationCurrencyAmendment {
		private final Boolean isApplicable;
		private final AmendmentEffectiveDate effectiveDate;
		private final List<? extends TerminationCurrencyElection> partyElection;
		
		protected TerminationCurrencyAmendmentImpl(TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder builder) {
			this.isApplicable = builder.getIsApplicable();
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isApplicable")
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public AmendmentEffectiveDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends TerminationCurrencyElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public TerminationCurrencyAmendment build() {
			return this;
		}
		
		@Override
		public TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder toBuilder() {
			TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder builder) {
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TerminationCurrencyAmendment _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TerminationCurrencyAmendment {" +
				"isApplicable=" + this.isApplicable + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"partyElection=" + this.partyElection +
			'}';
		}
	}

	/*********************** Builder Implementation of TerminationCurrencyAmendment  ***********************/
	class TerminationCurrencyAmendmentBuilderImpl implements TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder {
	
		protected Boolean isApplicable;
		protected AmendmentEffectiveDate.AmendmentEffectiveDateBuilder effectiveDate;
		protected List<TerminationCurrencyElection.TerminationCurrencyElectionBuilder> partyElection = new ArrayList<>();
		
		@Override
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("isApplicable")
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public AmendmentEffectiveDate.AmendmentEffectiveDateBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AmendmentEffectiveDate.AmendmentEffectiveDateBuilder getOrCreateEffectiveDate() {
			AmendmentEffectiveDate.AmendmentEffectiveDateBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AmendmentEffectiveDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends TerminationCurrencyElection.TerminationCurrencyElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public TerminationCurrencyElection.TerminationCurrencyElectionBuilder getOrCreatePartyElection(int index) {
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			return getIndex(partyElection, index, () -> {
						TerminationCurrencyElection.TerminationCurrencyElectionBuilder newPartyElection = TerminationCurrencyElection.builder();
						return newPartyElection;
					});
		}
		
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isApplicable")
		@Override
		public TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder setIsApplicable(Boolean _isApplicable) {
			this.isApplicable = _isApplicable == null ? null : _isApplicable;
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder setEffectiveDate(AmendmentEffectiveDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyElection")
		@Override
		public TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder addPartyElection(TerminationCurrencyElection _partyElection) {
			if (_partyElection != null) {
				this.partyElection.add(_partyElection.toBuilder());
			}
			return this;
		}
		
		@Override
		public TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder addPartyElection(TerminationCurrencyElection _partyElection, int idx) {
			getIndex(this.partyElection, idx, () -> _partyElection.toBuilder());
			return this;
		}
		
		@Override
		public TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder addPartyElection(List<? extends TerminationCurrencyElection> partyElections) {
			if (partyElections != null) {
				for (final TerminationCurrencyElection toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("partyElection")
		@Override
		public TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder setPartyElection(List<? extends TerminationCurrencyElection> partyElections) {
			if (partyElections == null) {
				this.partyElection = new ArrayList<>();
			} else {
				this.partyElection = partyElections.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public TerminationCurrencyAmendment build() {
			return new TerminationCurrencyAmendment.TerminationCurrencyAmendmentImpl(this);
		}
		
		@Override
		public TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder prune() {
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			partyElection = partyElection.stream().filter(b->b!=null).<TerminationCurrencyElection.TerminationCurrencyElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsApplicable()!=null) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder o = (TerminationCurrencyAmendment.TerminationCurrencyAmendmentBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TerminationCurrencyAmendment _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TerminationCurrencyAmendmentBuilder {" +
				"isApplicable=" + this.isApplicable + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
