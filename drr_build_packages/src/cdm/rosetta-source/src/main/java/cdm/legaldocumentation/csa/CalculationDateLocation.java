package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.CalculationDateLocationMeta;
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
 * A class to specify the Calculation Date Location election for the respective parties to the legal agreement.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Deed CSD_IM_English_2016 ISDA 2016 English Law Credit Support Deed for Initial Margin  
 * paragraph "13 General Principles" * clause "(d)(i)" * name "Calculation Date Location"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(e)(i)" * name "Calculation Date Location"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_NewYork_2016 ISDA 2016 New York Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(d)(i)" * name "Calculation Date Location"
 *
 * Provision 
 *
 */
@RosettaDataType(value="CalculationDateLocation", builder=CalculationDateLocation.CalculationDateLocationBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CalculationDateLocation", model="cdm", builder=CalculationDateLocation.CalculationDateLocationBuilderImpl.class, version="6.23.0")
public interface CalculationDateLocation extends RosettaModelObject {

	CalculationDateLocationMeta metaData = new CalculationDateLocationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The parties&#39; calculation date location election.
	 */
	List<? extends CalculationDateLocationElection> getPartyElection();

	/*********************** Build Methods  ***********************/
	CalculationDateLocation build();
	
	CalculationDateLocation.CalculationDateLocationBuilder toBuilder();
	
	static CalculationDateLocation.CalculationDateLocationBuilder builder() {
		return new CalculationDateLocation.CalculationDateLocationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationDateLocation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CalculationDateLocation> getType() {
		return CalculationDateLocation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyElection"), processor, CalculationDateLocationElection.class, getPartyElection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationDateLocationBuilder extends CalculationDateLocation, RosettaModelObjectBuilder {
		CalculationDateLocationElection.CalculationDateLocationElectionBuilder getOrCreatePartyElection(int index);
		@Override
		List<? extends CalculationDateLocationElection.CalculationDateLocationElectionBuilder> getPartyElection();
		CalculationDateLocation.CalculationDateLocationBuilder addPartyElection(CalculationDateLocationElection partyElection);
		CalculationDateLocation.CalculationDateLocationBuilder addPartyElection(CalculationDateLocationElection partyElection, int idx);
		CalculationDateLocation.CalculationDateLocationBuilder addPartyElection(List<? extends CalculationDateLocationElection> partyElection);
		CalculationDateLocation.CalculationDateLocationBuilder setPartyElection(List<? extends CalculationDateLocationElection> partyElection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyElection"), processor, CalculationDateLocationElection.CalculationDateLocationElectionBuilder.class, getPartyElection());
		}
		

		CalculationDateLocation.CalculationDateLocationBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationDateLocation  ***********************/
	class CalculationDateLocationImpl implements CalculationDateLocation {
		private final List<? extends CalculationDateLocationElection> partyElection;
		
		protected CalculationDateLocationImpl(CalculationDateLocation.CalculationDateLocationBuilder builder) {
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends CalculationDateLocationElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public CalculationDateLocation build() {
			return this;
		}
		
		@Override
		public CalculationDateLocation.CalculationDateLocationBuilder toBuilder() {
			CalculationDateLocation.CalculationDateLocationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationDateLocation.CalculationDateLocationBuilder builder) {
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationDateLocation _that = getType().cast(o);
		
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
			return "CalculationDateLocation {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}

	/*********************** Builder Implementation of CalculationDateLocation  ***********************/
	class CalculationDateLocationBuilderImpl implements CalculationDateLocation.CalculationDateLocationBuilder {
	
		protected List<CalculationDateLocationElection.CalculationDateLocationElectionBuilder> partyElection = new ArrayList<>();
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends CalculationDateLocationElection.CalculationDateLocationElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public CalculationDateLocationElection.CalculationDateLocationElectionBuilder getOrCreatePartyElection(int index) {
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			return getIndex(partyElection, index, () -> {
						CalculationDateLocationElection.CalculationDateLocationElectionBuilder newPartyElection = CalculationDateLocationElection.builder();
						return newPartyElection;
					});
		}
		
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		@Override
		public CalculationDateLocation.CalculationDateLocationBuilder addPartyElection(CalculationDateLocationElection _partyElection) {
			if (_partyElection != null) {
				this.partyElection.add(_partyElection.toBuilder());
			}
			return this;
		}
		
		@Override
		public CalculationDateLocation.CalculationDateLocationBuilder addPartyElection(CalculationDateLocationElection _partyElection, int idx) {
			getIndex(this.partyElection, idx, () -> _partyElection.toBuilder());
			return this;
		}
		
		@Override
		public CalculationDateLocation.CalculationDateLocationBuilder addPartyElection(List<? extends CalculationDateLocationElection> partyElections) {
			if (partyElections != null) {
				for (final CalculationDateLocationElection toAdd : partyElections) {
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
		public CalculationDateLocation.CalculationDateLocationBuilder setPartyElection(List<? extends CalculationDateLocationElection> partyElections) {
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
		public CalculationDateLocation build() {
			return new CalculationDateLocation.CalculationDateLocationImpl(this);
		}
		
		@Override
		public CalculationDateLocation.CalculationDateLocationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationDateLocation.CalculationDateLocationBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<CalculationDateLocationElection.CalculationDateLocationElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationDateLocation.CalculationDateLocationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculationDateLocation.CalculationDateLocationBuilder o = (CalculationDateLocation.CalculationDateLocationBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationDateLocation _that = getType().cast(o);
		
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
			return "CalculationDateLocationBuilder {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
