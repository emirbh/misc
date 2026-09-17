package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.MinimumTransferAmountMeta;
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
 * A class to specify amount of exposure reached before collateral has to be posted or returned.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Deed CSD_IM_English_2016 ISDA 2016 English Law Credit Support Deed for Initial Margin  
 * paragraph "13 General Principles" * clause "(c)(vi)(B)" * name "Minimum Transfer Amount"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(d)(vi)(B)" * name "Minimum Transfer Amount"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Annex CSA_IM_NewYork_2016 ISDA 2016 New York Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(c)(vi)(B)" * name "Minimum Transfer Amount"
 *
 * Provision 
 *
 */
@RosettaDataType(value="MinimumTransferAmount", builder=MinimumTransferAmount.MinimumTransferAmountBuilderImpl.class, version="6.23.0")
@RuneDataType(value="MinimumTransferAmount", model="cdm", builder=MinimumTransferAmount.MinimumTransferAmountBuilderImpl.class, version="6.23.0")
public interface MinimumTransferAmount extends RosettaModelObject {

	MinimumTransferAmountMeta metaData = new MinimumTransferAmountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The parties&#39; minimum transfer amount elections.
	 */
	List<? extends ElectiveAmountElection> getPartyElection();

	/*********************** Build Methods  ***********************/
	MinimumTransferAmount build();
	
	MinimumTransferAmount.MinimumTransferAmountBuilder toBuilder();
	
	static MinimumTransferAmount.MinimumTransferAmountBuilder builder() {
		return new MinimumTransferAmount.MinimumTransferAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MinimumTransferAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MinimumTransferAmount> getType() {
		return MinimumTransferAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyElection"), processor, ElectiveAmountElection.class, getPartyElection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MinimumTransferAmountBuilder extends MinimumTransferAmount, RosettaModelObjectBuilder {
		ElectiveAmountElection.ElectiveAmountElectionBuilder getOrCreatePartyElection(int index);
		@Override
		List<? extends ElectiveAmountElection.ElectiveAmountElectionBuilder> getPartyElection();
		MinimumTransferAmount.MinimumTransferAmountBuilder addPartyElection(ElectiveAmountElection partyElection);
		MinimumTransferAmount.MinimumTransferAmountBuilder addPartyElection(ElectiveAmountElection partyElection, int idx);
		MinimumTransferAmount.MinimumTransferAmountBuilder addPartyElection(List<? extends ElectiveAmountElection> partyElection);
		MinimumTransferAmount.MinimumTransferAmountBuilder setPartyElection(List<? extends ElectiveAmountElection> partyElection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyElection"), processor, ElectiveAmountElection.ElectiveAmountElectionBuilder.class, getPartyElection());
		}
		

		MinimumTransferAmount.MinimumTransferAmountBuilder prune();
	}

	/*********************** Immutable Implementation of MinimumTransferAmount  ***********************/
	class MinimumTransferAmountImpl implements MinimumTransferAmount {
		private final List<? extends ElectiveAmountElection> partyElection;
		
		protected MinimumTransferAmountImpl(MinimumTransferAmount.MinimumTransferAmountBuilder builder) {
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
		public MinimumTransferAmount build() {
			return this;
		}
		
		@Override
		public MinimumTransferAmount.MinimumTransferAmountBuilder toBuilder() {
			MinimumTransferAmount.MinimumTransferAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MinimumTransferAmount.MinimumTransferAmountBuilder builder) {
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MinimumTransferAmount _that = getType().cast(o);
		
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
			return "MinimumTransferAmount {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}

	/*********************** Builder Implementation of MinimumTransferAmount  ***********************/
	class MinimumTransferAmountBuilderImpl implements MinimumTransferAmount.MinimumTransferAmountBuilder {
	
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
		public MinimumTransferAmount.MinimumTransferAmountBuilder addPartyElection(ElectiveAmountElection _partyElection) {
			if (_partyElection != null) {
				this.partyElection.add(_partyElection.toBuilder());
			}
			return this;
		}
		
		@Override
		public MinimumTransferAmount.MinimumTransferAmountBuilder addPartyElection(ElectiveAmountElection _partyElection, int idx) {
			getIndex(this.partyElection, idx, () -> _partyElection.toBuilder());
			return this;
		}
		
		@Override
		public MinimumTransferAmount.MinimumTransferAmountBuilder addPartyElection(List<? extends ElectiveAmountElection> partyElections) {
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
		public MinimumTransferAmount.MinimumTransferAmountBuilder setPartyElection(List<? extends ElectiveAmountElection> partyElections) {
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
		public MinimumTransferAmount build() {
			return new MinimumTransferAmount.MinimumTransferAmountImpl(this);
		}
		
		@Override
		public MinimumTransferAmount.MinimumTransferAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MinimumTransferAmount.MinimumTransferAmountBuilder prune() {
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
		public MinimumTransferAmount.MinimumTransferAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MinimumTransferAmount.MinimumTransferAmountBuilder o = (MinimumTransferAmount.MinimumTransferAmountBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MinimumTransferAmount _that = getType().cast(o);
		
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
			return "MinimumTransferAmountBuilder {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
