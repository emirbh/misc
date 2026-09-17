package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.HoldingAndUsingPostedCollateralMeta;
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
 * A class to specify the elections for the holding and using of posted collateral.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_VM_2016 ISDA 2016 Credit Support Annex for Variation Margin  
 * paragraph "13" * clause " (h)" * name "Holding and Using Posted Collateral (VM)"
 *
 * Provision 
 *
 */
@RosettaDataType(value="HoldingAndUsingPostedCollateral", builder=HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilderImpl.class, version="6.23.0")
@RuneDataType(value="HoldingAndUsingPostedCollateral", model="cdm", builder=HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilderImpl.class, version="6.23.0")
public interface HoldingAndUsingPostedCollateral extends RosettaModelObject {

	HoldingAndUsingPostedCollateralMeta metaData = new HoldingAndUsingPostedCollateralMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The parties&#39; elections for the holding and using of posted collateral.
	 */
	List<? extends HoldingAndUsingPostedCollateralElection> getPartyElection();

	/*********************** Build Methods  ***********************/
	HoldingAndUsingPostedCollateral build();
	
	HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder toBuilder();
	
	static HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder builder() {
		return new HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends HoldingAndUsingPostedCollateral> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends HoldingAndUsingPostedCollateral> getType() {
		return HoldingAndUsingPostedCollateral.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyElection"), processor, HoldingAndUsingPostedCollateralElection.class, getPartyElection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface HoldingAndUsingPostedCollateralBuilder extends HoldingAndUsingPostedCollateral, RosettaModelObjectBuilder {
		HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder getOrCreatePartyElection(int index);
		@Override
		List<? extends HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder> getPartyElection();
		HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder addPartyElection(HoldingAndUsingPostedCollateralElection partyElection);
		HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder addPartyElection(HoldingAndUsingPostedCollateralElection partyElection, int idx);
		HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder addPartyElection(List<? extends HoldingAndUsingPostedCollateralElection> partyElection);
		HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder setPartyElection(List<? extends HoldingAndUsingPostedCollateralElection> partyElection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyElection"), processor, HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder.class, getPartyElection());
		}
		

		HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder prune();
	}

	/*********************** Immutable Implementation of HoldingAndUsingPostedCollateral  ***********************/
	class HoldingAndUsingPostedCollateralImpl implements HoldingAndUsingPostedCollateral {
		private final List<? extends HoldingAndUsingPostedCollateralElection> partyElection;
		
		protected HoldingAndUsingPostedCollateralImpl(HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder builder) {
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends HoldingAndUsingPostedCollateralElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public HoldingAndUsingPostedCollateral build() {
			return this;
		}
		
		@Override
		public HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder toBuilder() {
			HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder builder) {
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			HoldingAndUsingPostedCollateral _that = getType().cast(o);
		
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
			return "HoldingAndUsingPostedCollateral {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}

	/*********************** Builder Implementation of HoldingAndUsingPostedCollateral  ***********************/
	class HoldingAndUsingPostedCollateralBuilderImpl implements HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder {
	
		protected List<HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder> partyElection = new ArrayList<>();
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder getOrCreatePartyElection(int index) {
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			return getIndex(partyElection, index, () -> {
						HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder newPartyElection = HoldingAndUsingPostedCollateralElection.builder();
						return newPartyElection;
					});
		}
		
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		@Override
		public HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder addPartyElection(HoldingAndUsingPostedCollateralElection _partyElection) {
			if (_partyElection != null) {
				this.partyElection.add(_partyElection.toBuilder());
			}
			return this;
		}
		
		@Override
		public HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder addPartyElection(HoldingAndUsingPostedCollateralElection _partyElection, int idx) {
			getIndex(this.partyElection, idx, () -> _partyElection.toBuilder());
			return this;
		}
		
		@Override
		public HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder addPartyElection(List<? extends HoldingAndUsingPostedCollateralElection> partyElections) {
			if (partyElections != null) {
				for (final HoldingAndUsingPostedCollateralElection toAdd : partyElections) {
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
		public HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder setPartyElection(List<? extends HoldingAndUsingPostedCollateralElection> partyElections) {
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
		public HoldingAndUsingPostedCollateral build() {
			return new HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralImpl(this);
		}
		
		@Override
		public HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<HoldingAndUsingPostedCollateralElection.HoldingAndUsingPostedCollateralElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder o = (HoldingAndUsingPostedCollateral.HoldingAndUsingPostedCollateralBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			HoldingAndUsingPostedCollateral _that = getType().cast(o);
		
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
			return "HoldingAndUsingPostedCollateralBuilder {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
