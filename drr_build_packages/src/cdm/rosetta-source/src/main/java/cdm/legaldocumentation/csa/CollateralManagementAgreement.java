package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.CollateralManagementAgreementMeta;
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
 * A class to specify the Collateral Management Agreement election.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_Japanese_2016 ISDA 2016 Japanese Law Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * clause "(b)(i)" * name "Collateral Management Agreement"
 *
 * Provision 
 *
 */
@RosettaDataType(value="CollateralManagementAgreement", builder=CollateralManagementAgreement.CollateralManagementAgreementBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CollateralManagementAgreement", model="cdm", builder=CollateralManagementAgreement.CollateralManagementAgreementBuilderImpl.class, version="6.23.0")
public interface CollateralManagementAgreement extends RosettaModelObject {

	CollateralManagementAgreementMeta metaData = new CollateralManagementAgreementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The parties&#39; Collateral Management Agreement election.
	 */
	List<? extends CollateralManagementAgreementElection> getPartyElection();

	/*********************** Build Methods  ***********************/
	CollateralManagementAgreement build();
	
	CollateralManagementAgreement.CollateralManagementAgreementBuilder toBuilder();
	
	static CollateralManagementAgreement.CollateralManagementAgreementBuilder builder() {
		return new CollateralManagementAgreement.CollateralManagementAgreementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralManagementAgreement> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralManagementAgreement> getType() {
		return CollateralManagementAgreement.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyElection"), processor, CollateralManagementAgreementElection.class, getPartyElection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralManagementAgreementBuilder extends CollateralManagementAgreement, RosettaModelObjectBuilder {
		CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder getOrCreatePartyElection(int index);
		@Override
		List<? extends CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder> getPartyElection();
		CollateralManagementAgreement.CollateralManagementAgreementBuilder addPartyElection(CollateralManagementAgreementElection partyElection);
		CollateralManagementAgreement.CollateralManagementAgreementBuilder addPartyElection(CollateralManagementAgreementElection partyElection, int idx);
		CollateralManagementAgreement.CollateralManagementAgreementBuilder addPartyElection(List<? extends CollateralManagementAgreementElection> partyElection);
		CollateralManagementAgreement.CollateralManagementAgreementBuilder setPartyElection(List<? extends CollateralManagementAgreementElection> partyElection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyElection"), processor, CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder.class, getPartyElection());
		}
		

		CollateralManagementAgreement.CollateralManagementAgreementBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralManagementAgreement  ***********************/
	class CollateralManagementAgreementImpl implements CollateralManagementAgreement {
		private final List<? extends CollateralManagementAgreementElection> partyElection;
		
		protected CollateralManagementAgreementImpl(CollateralManagementAgreement.CollateralManagementAgreementBuilder builder) {
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends CollateralManagementAgreementElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public CollateralManagementAgreement build() {
			return this;
		}
		
		@Override
		public CollateralManagementAgreement.CollateralManagementAgreementBuilder toBuilder() {
			CollateralManagementAgreement.CollateralManagementAgreementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralManagementAgreement.CollateralManagementAgreementBuilder builder) {
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralManagementAgreement _that = getType().cast(o);
		
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
			return "CollateralManagementAgreement {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralManagementAgreement  ***********************/
	class CollateralManagementAgreementBuilderImpl implements CollateralManagementAgreement.CollateralManagementAgreementBuilder {
	
		protected List<CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder> partyElection = new ArrayList<>();
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder getOrCreatePartyElection(int index) {
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			return getIndex(partyElection, index, () -> {
						CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder newPartyElection = CollateralManagementAgreementElection.builder();
						return newPartyElection;
					});
		}
		
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		@Override
		public CollateralManagementAgreement.CollateralManagementAgreementBuilder addPartyElection(CollateralManagementAgreementElection _partyElection) {
			if (_partyElection != null) {
				this.partyElection.add(_partyElection.toBuilder());
			}
			return this;
		}
		
		@Override
		public CollateralManagementAgreement.CollateralManagementAgreementBuilder addPartyElection(CollateralManagementAgreementElection _partyElection, int idx) {
			getIndex(this.partyElection, idx, () -> _partyElection.toBuilder());
			return this;
		}
		
		@Override
		public CollateralManagementAgreement.CollateralManagementAgreementBuilder addPartyElection(List<? extends CollateralManagementAgreementElection> partyElections) {
			if (partyElections != null) {
				for (final CollateralManagementAgreementElection toAdd : partyElections) {
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
		public CollateralManagementAgreement.CollateralManagementAgreementBuilder setPartyElection(List<? extends CollateralManagementAgreementElection> partyElections) {
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
		public CollateralManagementAgreement build() {
			return new CollateralManagementAgreement.CollateralManagementAgreementImpl(this);
		}
		
		@Override
		public CollateralManagementAgreement.CollateralManagementAgreementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralManagementAgreement.CollateralManagementAgreementBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<CollateralManagementAgreementElection.CollateralManagementAgreementElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralManagementAgreement.CollateralManagementAgreementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralManagementAgreement.CollateralManagementAgreementBuilder o = (CollateralManagementAgreement.CollateralManagementAgreementBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralManagementAgreement _that = getType().cast(o);
		
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
			return "CollateralManagementAgreementBuilder {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
