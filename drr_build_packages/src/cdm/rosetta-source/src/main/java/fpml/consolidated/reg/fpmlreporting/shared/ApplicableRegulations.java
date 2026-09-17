package fpml.consolidated.reg.fpmlreporting.shared;

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
import fpml.consolidated.reg.fpmlreporting.shared.meta.ApplicableRegulationsMeta;
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
 * Provision Speccifies the list ofregulations the trade is subject to reporting.
 *
 */
@RosettaDataType(value="ApplicableRegulations", builder=ApplicableRegulations.ApplicableRegulationsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ApplicableRegulations", model="fpml", builder=ApplicableRegulations.ApplicableRegulationsBuilderImpl.class, version="2.1.1")
public interface ApplicableRegulations extends RosettaModelObject {

	ApplicableRegulationsMeta metaData = new ApplicableRegulationsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends RegulatorApplicability> getRegulatorApplicability();

	/*********************** Build Methods  ***********************/
	ApplicableRegulations build();
	
	ApplicableRegulations.ApplicableRegulationsBuilder toBuilder();
	
	static ApplicableRegulations.ApplicableRegulationsBuilder builder() {
		return new ApplicableRegulations.ApplicableRegulationsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ApplicableRegulations> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ApplicableRegulations> getType() {
		return ApplicableRegulations.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("regulatorApplicability"), processor, RegulatorApplicability.class, getRegulatorApplicability());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ApplicableRegulationsBuilder extends ApplicableRegulations, RosettaModelObjectBuilder {
		RegulatorApplicability.RegulatorApplicabilityBuilder getOrCreateRegulatorApplicability(int index);
		@Override
		List<? extends RegulatorApplicability.RegulatorApplicabilityBuilder> getRegulatorApplicability();
		ApplicableRegulations.ApplicableRegulationsBuilder addRegulatorApplicability(RegulatorApplicability regulatorApplicability);
		ApplicableRegulations.ApplicableRegulationsBuilder addRegulatorApplicability(RegulatorApplicability regulatorApplicability, int idx);
		ApplicableRegulations.ApplicableRegulationsBuilder addRegulatorApplicability(List<? extends RegulatorApplicability> regulatorApplicability);
		ApplicableRegulations.ApplicableRegulationsBuilder setRegulatorApplicability(List<? extends RegulatorApplicability> regulatorApplicability);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("regulatorApplicability"), processor, RegulatorApplicability.RegulatorApplicabilityBuilder.class, getRegulatorApplicability());
		}
		

		ApplicableRegulations.ApplicableRegulationsBuilder prune();
	}

	/*********************** Immutable Implementation of ApplicableRegulations  ***********************/
	class ApplicableRegulationsImpl implements ApplicableRegulations {
		private final List<? extends RegulatorApplicability> regulatorApplicability;
		
		protected ApplicableRegulationsImpl(ApplicableRegulations.ApplicableRegulationsBuilder builder) {
			this.regulatorApplicability = ofNullable(builder.getRegulatorApplicability()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("regulatorApplicability")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("regulatorApplicability")
		public List<? extends RegulatorApplicability> getRegulatorApplicability() {
			return regulatorApplicability;
		}
		
		@Override
		public ApplicableRegulations build() {
			return this;
		}
		
		@Override
		public ApplicableRegulations.ApplicableRegulationsBuilder toBuilder() {
			ApplicableRegulations.ApplicableRegulationsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ApplicableRegulations.ApplicableRegulationsBuilder builder) {
			ofNullable(getRegulatorApplicability()).ifPresent(builder::setRegulatorApplicability);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApplicableRegulations _that = getType().cast(o);
		
			if (!ListEquals.listEquals(regulatorApplicability, _that.getRegulatorApplicability())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (regulatorApplicability != null ? regulatorApplicability.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicableRegulations {" +
				"regulatorApplicability=" + this.regulatorApplicability +
			'}';
		}
	}

	/*********************** Builder Implementation of ApplicableRegulations  ***********************/
	class ApplicableRegulationsBuilderImpl implements ApplicableRegulations.ApplicableRegulationsBuilder {
	
		protected List<RegulatorApplicability.RegulatorApplicabilityBuilder> regulatorApplicability = new ArrayList<>();
		
		@Override
		@RosettaAttribute("regulatorApplicability")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("regulatorApplicability")
		public List<? extends RegulatorApplicability.RegulatorApplicabilityBuilder> getRegulatorApplicability() {
			return regulatorApplicability;
		}
		
		@Override
		public RegulatorApplicability.RegulatorApplicabilityBuilder getOrCreateRegulatorApplicability(int index) {
			if (regulatorApplicability==null) {
				this.regulatorApplicability = new ArrayList<>();
			}
			return getIndex(regulatorApplicability, index, () -> {
						RegulatorApplicability.RegulatorApplicabilityBuilder newRegulatorApplicability = RegulatorApplicability.builder();
						return newRegulatorApplicability;
					});
		}
		
		@RosettaAttribute("regulatorApplicability")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("regulatorApplicability")
		@Override
		public ApplicableRegulations.ApplicableRegulationsBuilder addRegulatorApplicability(RegulatorApplicability _regulatorApplicability) {
			if (_regulatorApplicability != null) {
				this.regulatorApplicability.add(_regulatorApplicability.toBuilder());
			}
			return this;
		}
		
		@Override
		public ApplicableRegulations.ApplicableRegulationsBuilder addRegulatorApplicability(RegulatorApplicability _regulatorApplicability, int idx) {
			getIndex(this.regulatorApplicability, idx, () -> _regulatorApplicability.toBuilder());
			return this;
		}
		
		@Override
		public ApplicableRegulations.ApplicableRegulationsBuilder addRegulatorApplicability(List<? extends RegulatorApplicability> regulatorApplicabilitys) {
			if (regulatorApplicabilitys != null) {
				for (final RegulatorApplicability toAdd : regulatorApplicabilitys) {
					this.regulatorApplicability.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("regulatorApplicability")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("regulatorApplicability")
		@Override
		public ApplicableRegulations.ApplicableRegulationsBuilder setRegulatorApplicability(List<? extends RegulatorApplicability> regulatorApplicabilitys) {
			if (regulatorApplicabilitys == null) {
				this.regulatorApplicability = new ArrayList<>();
			} else {
				this.regulatorApplicability = regulatorApplicabilitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ApplicableRegulations build() {
			return new ApplicableRegulations.ApplicableRegulationsImpl(this);
		}
		
		@Override
		public ApplicableRegulations.ApplicableRegulationsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicableRegulations.ApplicableRegulationsBuilder prune() {
			regulatorApplicability = regulatorApplicability.stream().filter(b->b!=null).<RegulatorApplicability.RegulatorApplicabilityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRegulatorApplicability()!=null && getRegulatorApplicability().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ApplicableRegulations.ApplicableRegulationsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ApplicableRegulations.ApplicableRegulationsBuilder o = (ApplicableRegulations.ApplicableRegulationsBuilder) other;
			
			merger.mergeRosetta(getRegulatorApplicability(), o.getRegulatorApplicability(), this::getOrCreateRegulatorApplicability);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ApplicableRegulations _that = getType().cast(o);
		
			if (!ListEquals.listEquals(regulatorApplicability, _that.getRegulatorApplicability())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (regulatorApplicability != null ? regulatorApplicability.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ApplicableRegulationsBuilder {" +
				"regulatorApplicability=" + this.regulatorApplicability +
			'}';
		}
	}
}
