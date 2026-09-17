package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.CustodianRiskMeta;
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
 * A class to specify the Custodian Risk elections specific to a Credit Support Agreement.
 * @version 6.23.0
 */
@RosettaDataType(value="CustodianRisk", builder=CustodianRisk.CustodianRiskBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CustodianRisk", model="cdm", builder=CustodianRisk.CustodianRiskBuilderImpl.class, version="6.23.0")
public interface CustodianRisk extends RosettaModelObject {

	CustodianRiskMeta metaData = new CustodianRiskMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The party specific elections.
	 */
	List<? extends CustodianRiskElection> getPartyElection();

	/*********************** Build Methods  ***********************/
	CustodianRisk build();
	
	CustodianRisk.CustodianRiskBuilder toBuilder();
	
	static CustodianRisk.CustodianRiskBuilder builder() {
		return new CustodianRisk.CustodianRiskBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CustodianRisk> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CustodianRisk> getType() {
		return CustodianRisk.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyElection"), processor, CustodianRiskElection.class, getPartyElection());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CustodianRiskBuilder extends CustodianRisk, RosettaModelObjectBuilder {
		CustodianRiskElection.CustodianRiskElectionBuilder getOrCreatePartyElection(int index);
		@Override
		List<? extends CustodianRiskElection.CustodianRiskElectionBuilder> getPartyElection();
		CustodianRisk.CustodianRiskBuilder addPartyElection(CustodianRiskElection partyElection);
		CustodianRisk.CustodianRiskBuilder addPartyElection(CustodianRiskElection partyElection, int idx);
		CustodianRisk.CustodianRiskBuilder addPartyElection(List<? extends CustodianRiskElection> partyElection);
		CustodianRisk.CustodianRiskBuilder setPartyElection(List<? extends CustodianRiskElection> partyElection);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyElection"), processor, CustodianRiskElection.CustodianRiskElectionBuilder.class, getPartyElection());
		}
		

		CustodianRisk.CustodianRiskBuilder prune();
	}

	/*********************** Immutable Implementation of CustodianRisk  ***********************/
	class CustodianRiskImpl implements CustodianRisk {
		private final List<? extends CustodianRiskElection> partyElection;
		
		protected CustodianRiskImpl(CustodianRisk.CustodianRiskBuilder builder) {
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends CustodianRiskElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public CustodianRisk build() {
			return this;
		}
		
		@Override
		public CustodianRisk.CustodianRiskBuilder toBuilder() {
			CustodianRisk.CustodianRiskBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CustodianRisk.CustodianRiskBuilder builder) {
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodianRisk _that = getType().cast(o);
		
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
			return "CustodianRisk {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}

	/*********************** Builder Implementation of CustodianRisk  ***********************/
	class CustodianRiskBuilderImpl implements CustodianRisk.CustodianRiskBuilder {
	
		protected List<CustodianRiskElection.CustodianRiskElectionBuilder> partyElection = new ArrayList<>();
		
		@Override
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		public List<? extends CustodianRiskElection.CustodianRiskElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public CustodianRiskElection.CustodianRiskElectionBuilder getOrCreatePartyElection(int index) {
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			return getIndex(partyElection, index, () -> {
						CustodianRiskElection.CustodianRiskElectionBuilder newPartyElection = CustodianRiskElection.builder();
						return newPartyElection;
					});
		}
		
		@RosettaAttribute("partyElection")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("partyElection")
		@Override
		public CustodianRisk.CustodianRiskBuilder addPartyElection(CustodianRiskElection _partyElection) {
			if (_partyElection != null) {
				this.partyElection.add(_partyElection.toBuilder());
			}
			return this;
		}
		
		@Override
		public CustodianRisk.CustodianRiskBuilder addPartyElection(CustodianRiskElection _partyElection, int idx) {
			getIndex(this.partyElection, idx, () -> _partyElection.toBuilder());
			return this;
		}
		
		@Override
		public CustodianRisk.CustodianRiskBuilder addPartyElection(List<? extends CustodianRiskElection> partyElections) {
			if (partyElections != null) {
				for (final CustodianRiskElection toAdd : partyElections) {
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
		public CustodianRisk.CustodianRiskBuilder setPartyElection(List<? extends CustodianRiskElection> partyElections) {
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
		public CustodianRisk build() {
			return new CustodianRisk.CustodianRiskImpl(this);
		}
		
		@Override
		public CustodianRisk.CustodianRiskBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodianRisk.CustodianRiskBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<CustodianRiskElection.CustodianRiskElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodianRisk.CustodianRiskBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CustodianRisk.CustodianRiskBuilder o = (CustodianRisk.CustodianRiskBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodianRisk _that = getType().cast(o);
		
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
			return "CustodianRiskBuilder {" +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
