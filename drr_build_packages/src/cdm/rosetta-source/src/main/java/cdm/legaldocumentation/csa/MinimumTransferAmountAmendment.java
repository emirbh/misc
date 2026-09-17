package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.MinimumTransferAmountAmendmentMeta;
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
 *  A class to specify whether Amendment to Minimum Transfer Amount language is applicable or not.
 * @version 6.23.0
 */
@RosettaDataType(value="MinimumTransferAmountAmendment", builder=MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilderImpl.class, version="6.23.0")
@RuneDataType(value="MinimumTransferAmountAmendment", model="cdm", builder=MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilderImpl.class, version="6.23.0")
public interface MinimumTransferAmountAmendment extends RosettaModelObject {

	MinimumTransferAmountAmendmentMeta metaData = new MinimumTransferAmountAmendmentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The definition of Minimum Transfer Amount in any Other Regulatory CSA will be amended when applicable.
	 */
	Boolean getIsApplicable();
	/**
	 * The effective date of the Amendment to Termination Currency.
	 */
	AmendmentEffectiveDate getEffectiveDate();
	/**
	 * The party elective amounts.
	 */
	List<? extends ElectiveAmountElection> getPartyElections();

	/*********************** Build Methods  ***********************/
	MinimumTransferAmountAmendment build();
	
	MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder toBuilder();
	
	static MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder builder() {
		return new MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MinimumTransferAmountAmendment> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MinimumTransferAmountAmendment> getType() {
		return MinimumTransferAmountAmendment.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		processRosetta(path.newSubPath("effectiveDate"), processor, AmendmentEffectiveDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("partyElections"), processor, ElectiveAmountElection.class, getPartyElections());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MinimumTransferAmountAmendmentBuilder extends MinimumTransferAmountAmendment, RosettaModelObjectBuilder {
		AmendmentEffectiveDate.AmendmentEffectiveDateBuilder getOrCreateEffectiveDate();
		@Override
		AmendmentEffectiveDate.AmendmentEffectiveDateBuilder getEffectiveDate();
		ElectiveAmountElection.ElectiveAmountElectionBuilder getOrCreatePartyElections(int index);
		@Override
		List<? extends ElectiveAmountElection.ElectiveAmountElectionBuilder> getPartyElections();
		MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder setIsApplicable(Boolean isApplicable);
		MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder setEffectiveDate(AmendmentEffectiveDate effectiveDate);
		MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder addPartyElections(ElectiveAmountElection partyElections);
		MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder addPartyElections(ElectiveAmountElection partyElections, int idx);
		MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder addPartyElections(List<? extends ElectiveAmountElection> partyElections);
		MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder setPartyElections(List<? extends ElectiveAmountElection> partyElections);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			processRosetta(path.newSubPath("effectiveDate"), processor, AmendmentEffectiveDate.AmendmentEffectiveDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("partyElections"), processor, ElectiveAmountElection.ElectiveAmountElectionBuilder.class, getPartyElections());
		}
		

		MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder prune();
	}

	/*********************** Immutable Implementation of MinimumTransferAmountAmendment  ***********************/
	class MinimumTransferAmountAmendmentImpl implements MinimumTransferAmountAmendment {
		private final Boolean isApplicable;
		private final AmendmentEffectiveDate effectiveDate;
		private final List<? extends ElectiveAmountElection> partyElections;
		
		protected MinimumTransferAmountAmendmentImpl(MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder builder) {
			this.isApplicable = builder.getIsApplicable();
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.partyElections = ofNullable(builder.getPartyElections()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		@RosettaAttribute("partyElections")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyElections")
		public List<? extends ElectiveAmountElection> getPartyElections() {
			return partyElections;
		}
		
		@Override
		public MinimumTransferAmountAmendment build() {
			return this;
		}
		
		@Override
		public MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder toBuilder() {
			MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder builder) {
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getPartyElections()).ifPresent(builder::setPartyElections);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MinimumTransferAmountAmendment _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!ListEquals.listEquals(partyElections, _that.getPartyElections())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (partyElections != null ? partyElections.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MinimumTransferAmountAmendment {" +
				"isApplicable=" + this.isApplicable + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"partyElections=" + this.partyElections +
			'}';
		}
	}

	/*********************** Builder Implementation of MinimumTransferAmountAmendment  ***********************/
	class MinimumTransferAmountAmendmentBuilderImpl implements MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder {
	
		protected Boolean isApplicable;
		protected AmendmentEffectiveDate.AmendmentEffectiveDateBuilder effectiveDate;
		protected List<ElectiveAmountElection.ElectiveAmountElectionBuilder> partyElections = new ArrayList<>();
		
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
		@RosettaAttribute("partyElections")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyElections")
		public List<? extends ElectiveAmountElection.ElectiveAmountElectionBuilder> getPartyElections() {
			return partyElections;
		}
		
		@Override
		public ElectiveAmountElection.ElectiveAmountElectionBuilder getOrCreatePartyElections(int index) {
			if (partyElections==null) {
				this.partyElections = new ArrayList<>();
			}
			return getIndex(partyElections, index, () -> {
						ElectiveAmountElection.ElectiveAmountElectionBuilder newPartyElections = ElectiveAmountElection.builder();
						return newPartyElections;
					});
		}
		
		@RosettaAttribute("isApplicable")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("isApplicable")
		@Override
		public MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder setIsApplicable(Boolean _isApplicable) {
			this.isApplicable = _isApplicable == null ? null : _isApplicable;
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder setEffectiveDate(AmendmentEffectiveDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyElections")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyElections")
		@Override
		public MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder addPartyElections(ElectiveAmountElection _partyElections) {
			if (_partyElections != null) {
				this.partyElections.add(_partyElections.toBuilder());
			}
			return this;
		}
		
		@Override
		public MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder addPartyElections(ElectiveAmountElection _partyElections, int idx) {
			getIndex(this.partyElections, idx, () -> _partyElections.toBuilder());
			return this;
		}
		
		@Override
		public MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder addPartyElections(List<? extends ElectiveAmountElection> partyElectionss) {
			if (partyElectionss != null) {
				for (final ElectiveAmountElection toAdd : partyElectionss) {
					this.partyElections.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyElections")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("partyElections")
		@Override
		public MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder setPartyElections(List<? extends ElectiveAmountElection> partyElectionss) {
			if (partyElectionss == null) {
				this.partyElections = new ArrayList<>();
			} else {
				this.partyElections = partyElectionss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public MinimumTransferAmountAmendment build() {
			return new MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentImpl(this);
		}
		
		@Override
		public MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder prune() {
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			partyElections = partyElections.stream().filter(b->b!=null).<ElectiveAmountElection.ElectiveAmountElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsApplicable()!=null) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getPartyElections()!=null && getPartyElections().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder o = (MinimumTransferAmountAmendment.MinimumTransferAmountAmendmentBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getPartyElections(), o.getPartyElections(), this::getOrCreatePartyElections);
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MinimumTransferAmountAmendment _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!ListEquals.listEquals(partyElections, _that.getPartyElections())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (partyElections != null ? partyElections.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MinimumTransferAmountAmendmentBuilder {" +
				"isApplicable=" + this.isApplicable + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"partyElections=" + this.partyElections +
			'}';
		}
	}
}
