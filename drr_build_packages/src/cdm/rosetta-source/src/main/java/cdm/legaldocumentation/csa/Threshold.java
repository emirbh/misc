package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.ThresholdMeta;
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
 * A class to specify the unsecured credit exposure that each party to the agreement is prepared to accept before asking for collateral.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Deed CSD_IM_English_2016 ISDA 2016 English Law Credit Support Deed for Initial Margin  
 * paragraph "13 General Principles" * clause "(c)(vi)(A)" * name "Threshold"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(d)(vi)(A)" * name "Threshold"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_NewYork_2016 ISDA 2016 New York Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(c)(vi)(A)" * name "Threshold"
 *
 * Provision 
 *
 */
@RosettaDataType(value="Threshold", builder=Threshold.ThresholdBuilderImpl.class, version="6.23.0")
@RuneDataType(value="Threshold", model="cdm", builder=Threshold.ThresholdBuilderImpl.class, version="6.23.0")
public interface Threshold extends RosettaModelObject {

	ThresholdMeta metaData = new ThresholdMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The parties&#39; Threshold election.
	 */
	List<? extends ElectiveAmountElection> getPartyElection();

	/*********************** Build Methods  ***********************/
	Threshold build();
	
	Threshold.ThresholdBuilder toBuilder();
	
	static Threshold.ThresholdBuilder builder() {
		return new Threshold.ThresholdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Threshold> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Threshold> getType() {
		return Threshold.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyElection"), processor, ElectiveAmountElection.class, getPartyElection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ThresholdBuilder extends Threshold, RosettaModelObjectBuilder {
		ElectiveAmountElection.ElectiveAmountElectionBuilder getOrCreatePartyElection(int index);
		@Override
		List<? extends ElectiveAmountElection.ElectiveAmountElectionBuilder> getPartyElection();
		Threshold.ThresholdBuilder addPartyElection(ElectiveAmountElection partyElection);
		Threshold.ThresholdBuilder addPartyElection(ElectiveAmountElection partyElection, int idx);
		Threshold.ThresholdBuilder addPartyElection(List<? extends ElectiveAmountElection> partyElection);
		Threshold.ThresholdBuilder setPartyElection(List<? extends ElectiveAmountElection> partyElection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyElection"), processor, ElectiveAmountElection.ElectiveAmountElectionBuilder.class, getPartyElection());
		}
		

		Threshold.ThresholdBuilder prune();
	}

	/*********************** Immutable Implementation of Threshold  ***********************/
	class ThresholdImpl implements Threshold {
		private final List<? extends ElectiveAmountElection> partyElection;
		
		protected ThresholdImpl(Threshold.ThresholdBuilder builder) {
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends ElectiveAmountElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public Threshold build() {
			return this;
		}
		
		@Override
		public Threshold.ThresholdBuilder toBuilder() {
			Threshold.ThresholdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Threshold.ThresholdBuilder builder) {
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Threshold _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Threshold {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}

	/*********************** Builder Implementation of Threshold  ***********************/
	class ThresholdBuilderImpl implements Threshold.ThresholdBuilder {
	
		protected List<ElectiveAmountElection.ElectiveAmountElectionBuilder> partyElection = new ArrayList<>();
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends ElectiveAmountElection.ElectiveAmountElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public ElectiveAmountElection.ElectiveAmountElectionBuilder getOrCreatePartyElection(int index) {
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			return getIndex(partyElection, index, () -> {
						ElectiveAmountElection.ElectiveAmountElectionBuilder newPartyElection = ElectiveAmountElection.builder();
						return newPartyElection;
					});
		}
		
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		@Override
		public Threshold.ThresholdBuilder addPartyElection(ElectiveAmountElection _partyElection) {
			if (_partyElection != null) {
				this.partyElection.add(_partyElection.toBuilder());
			}
			return this;
		}
		
		@Override
		public Threshold.ThresholdBuilder addPartyElection(ElectiveAmountElection _partyElection, int idx) {
			getIndex(this.partyElection, idx, () -> _partyElection.toBuilder());
			return this;
		}
		
		@Override
		public Threshold.ThresholdBuilder addPartyElection(List<? extends ElectiveAmountElection> partyElections) {
			if (partyElections != null) {
				for (final ElectiveAmountElection toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		@Override
		public Threshold.ThresholdBuilder setPartyElection(List<? extends ElectiveAmountElection> partyElections) {
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
		public Threshold build() {
			return new Threshold.ThresholdImpl(this);
		}
		
		@Override
		public Threshold.ThresholdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Threshold.ThresholdBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<ElectiveAmountElection.ElectiveAmountElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Threshold.ThresholdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Threshold.ThresholdBuilder o = (Threshold.ThresholdBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Threshold _that = getType().cast(o);
		
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ThresholdBuilder {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
