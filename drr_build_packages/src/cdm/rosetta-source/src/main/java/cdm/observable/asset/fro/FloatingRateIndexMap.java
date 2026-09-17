package cdm.observable.asset.fro;

import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum;
import cdm.base.staticdata.identifier.Identifier;
import cdm.observable.asset.fro.meta.FloatingRateIndexMapMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A map for a single FRO to or from an equivalent or similar FRO in a different contractual definitions version.
 * @version 6.23.0
 */
@RosettaDataType(value="FloatingRateIndexMap", builder=FloatingRateIndexMap.FloatingRateIndexMapBuilderImpl.class, version="6.23.0")
@RuneDataType(value="FloatingRateIndexMap", model="cdm", builder=FloatingRateIndexMap.FloatingRateIndexMapBuilderImpl.class, version="6.23.0")
public interface FloatingRateIndexMap extends RosettaModelObject {

	FloatingRateIndexMapMeta metaData = new FloatingRateIndexMapMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *  The FRO name that is being mapped to/from.
	 */
	List<FloatingRateIndexEnum> getIndex();
	/**
	 * Contractual Definition to which the map applies. Includes Document Type and Document Version
	 */
	ContractualDefinitionIdentifier getContractualDefinitionIdentifier();
	/**
	 * Corresponds to the unique identifier of the Contractual Definition to which the map applies
	 */
	Identifier getIdentifier();

	/*********************** Build Methods  ***********************/
	FloatingRateIndexMap build();
	
	FloatingRateIndexMap.FloatingRateIndexMapBuilder toBuilder();
	
	static FloatingRateIndexMap.FloatingRateIndexMapBuilder builder() {
		return new FloatingRateIndexMap.FloatingRateIndexMapBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateIndexMap> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingRateIndexMap> getType() {
		return FloatingRateIndexMap.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("index"), FloatingRateIndexEnum.class, getIndex(), this);
		processRosetta(path.newSubPath("contractualDefinitionIdentifier"), processor, ContractualDefinitionIdentifier.class, getContractualDefinitionIdentifier());
		processRosetta(path.newSubPath("identifier"), processor, Identifier.class, getIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateIndexMapBuilder extends FloatingRateIndexMap, RosettaModelObjectBuilder {
		ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder getOrCreateContractualDefinitionIdentifier();
		@Override
		ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder getContractualDefinitionIdentifier();
		Identifier.IdentifierBuilder getOrCreateIdentifier();
		@Override
		Identifier.IdentifierBuilder getIdentifier();
		FloatingRateIndexMap.FloatingRateIndexMapBuilder addIndex(FloatingRateIndexEnum index);
		FloatingRateIndexMap.FloatingRateIndexMapBuilder addIndex(FloatingRateIndexEnum index, int idx);
		FloatingRateIndexMap.FloatingRateIndexMapBuilder addIndex(List<FloatingRateIndexEnum> index);
		FloatingRateIndexMap.FloatingRateIndexMapBuilder setIndex(List<FloatingRateIndexEnum> index);
		FloatingRateIndexMap.FloatingRateIndexMapBuilder setContractualDefinitionIdentifier(ContractualDefinitionIdentifier contractualDefinitionIdentifier);
		FloatingRateIndexMap.FloatingRateIndexMapBuilder setIdentifier(Identifier identifier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("index"), FloatingRateIndexEnum.class, getIndex(), this);
			processRosetta(path.newSubPath("contractualDefinitionIdentifier"), processor, ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder.class, getContractualDefinitionIdentifier());
			processRosetta(path.newSubPath("identifier"), processor, Identifier.IdentifierBuilder.class, getIdentifier());
		}
		

		FloatingRateIndexMap.FloatingRateIndexMapBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateIndexMap  ***********************/
	class FloatingRateIndexMapImpl implements FloatingRateIndexMap {
		private final List<FloatingRateIndexEnum> index;
		private final ContractualDefinitionIdentifier contractualDefinitionIdentifier;
		private final Identifier identifier;
		
		protected FloatingRateIndexMapImpl(FloatingRateIndexMap.FloatingRateIndexMapBuilder builder) {
			this.index = ofNullable(builder.getIndex()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.contractualDefinitionIdentifier = ofNullable(builder.getContractualDefinitionIdentifier()).map(f->f.build()).orElse(null);
			this.identifier = ofNullable(builder.getIdentifier()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("index")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("index")
		public List<FloatingRateIndexEnum> getIndex() {
			return index;
		}
		
		@Override
		@RosettaAttribute("contractualDefinitionIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractualDefinitionIdentifier")
		public ContractualDefinitionIdentifier getContractualDefinitionIdentifier() {
			return contractualDefinitionIdentifier;
		}
		
		@Override
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("identifier")
		public Identifier getIdentifier() {
			return identifier;
		}
		
		@Override
		public FloatingRateIndexMap build() {
			return this;
		}
		
		@Override
		public FloatingRateIndexMap.FloatingRateIndexMapBuilder toBuilder() {
			FloatingRateIndexMap.FloatingRateIndexMapBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateIndexMap.FloatingRateIndexMapBuilder builder) {
			ofNullable(getIndex()).ifPresent(builder::setIndex);
			ofNullable(getContractualDefinitionIdentifier()).ifPresent(builder::setContractualDefinitionIdentifier);
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndexMap _that = getType().cast(o);
		
			if (!ListEquals.listEquals(index, _that.getIndex())) return false;
			if (!Objects.equals(contractualDefinitionIdentifier, _that.getContractualDefinitionIdentifier())) return false;
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (index != null ? index.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (contractualDefinitionIdentifier != null ? contractualDefinitionIdentifier.hashCode() : 0);
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexMap {" +
				"index=" + this.index + ", " +
				"contractualDefinitionIdentifier=" + this.contractualDefinitionIdentifier + ", " +
				"identifier=" + this.identifier +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingRateIndexMap  ***********************/
	class FloatingRateIndexMapBuilderImpl implements FloatingRateIndexMap.FloatingRateIndexMapBuilder {
	
		protected List<FloatingRateIndexEnum> index = new ArrayList<>();
		protected ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder contractualDefinitionIdentifier;
		protected Identifier.IdentifierBuilder identifier;
		
		@Override
		@RosettaAttribute("index")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("index")
		public List<FloatingRateIndexEnum> getIndex() {
			return index;
		}
		
		@Override
		@RosettaAttribute("contractualDefinitionIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("contractualDefinitionIdentifier")
		public ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder getContractualDefinitionIdentifier() {
			return contractualDefinitionIdentifier;
		}
		
		@Override
		public ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder getOrCreateContractualDefinitionIdentifier() {
			ContractualDefinitionIdentifier.ContractualDefinitionIdentifierBuilder result;
			if (contractualDefinitionIdentifier!=null) {
				result = contractualDefinitionIdentifier;
			}
			else {
				result = contractualDefinitionIdentifier = ContractualDefinitionIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("identifier")
		public Identifier.IdentifierBuilder getIdentifier() {
			return identifier;
		}
		
		@Override
		public Identifier.IdentifierBuilder getOrCreateIdentifier() {
			Identifier.IdentifierBuilder result;
			if (identifier!=null) {
				result = identifier;
			}
			else {
				result = identifier = Identifier.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("index")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("index")
		@Override
		public FloatingRateIndexMap.FloatingRateIndexMapBuilder addIndex(FloatingRateIndexEnum _index) {
			if (_index != null) {
				this.index.add(_index);
			}
			return this;
		}
		
		@Override
		public FloatingRateIndexMap.FloatingRateIndexMapBuilder addIndex(FloatingRateIndexEnum _index, int idx) {
			getIndex(this.index, idx, () -> _index);
			return this;
		}
		
		@Override
		public FloatingRateIndexMap.FloatingRateIndexMapBuilder addIndex(List<FloatingRateIndexEnum> indexs) {
			if (indexs != null) {
				for (final FloatingRateIndexEnum toAdd : indexs) {
					this.index.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("index")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("index")
		@Override
		public FloatingRateIndexMap.FloatingRateIndexMapBuilder setIndex(List<FloatingRateIndexEnum> indexs) {
			if (indexs == null) {
				this.index = new ArrayList<>();
			} else {
				this.index = indexs.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("contractualDefinitionIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("contractualDefinitionIdentifier")
		@Override
		public FloatingRateIndexMap.FloatingRateIndexMapBuilder setContractualDefinitionIdentifier(ContractualDefinitionIdentifier _contractualDefinitionIdentifier) {
			this.contractualDefinitionIdentifier = _contractualDefinitionIdentifier == null ? null : _contractualDefinitionIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("identifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("identifier")
		@Override
		public FloatingRateIndexMap.FloatingRateIndexMapBuilder setIdentifier(Identifier _identifier) {
			this.identifier = _identifier == null ? null : _identifier.toBuilder();
			return this;
		}
		
		@Override
		public FloatingRateIndexMap build() {
			return new FloatingRateIndexMap.FloatingRateIndexMapImpl(this);
		}
		
		@Override
		public FloatingRateIndexMap.FloatingRateIndexMapBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexMap.FloatingRateIndexMapBuilder prune() {
			if (contractualDefinitionIdentifier!=null && !contractualDefinitionIdentifier.prune().hasData()) contractualDefinitionIdentifier = null;
			if (identifier!=null && !identifier.prune().hasData()) identifier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIndex()!=null && !getIndex().isEmpty()) return true;
			if (getContractualDefinitionIdentifier()!=null && getContractualDefinitionIdentifier().hasData()) return true;
			if (getIdentifier()!=null && getIdentifier().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexMap.FloatingRateIndexMapBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRateIndexMap.FloatingRateIndexMapBuilder o = (FloatingRateIndexMap.FloatingRateIndexMapBuilder) other;
			
			merger.mergeRosetta(getContractualDefinitionIdentifier(), o.getContractualDefinitionIdentifier(), this::setContractualDefinitionIdentifier);
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::setIdentifier);
			
			merger.mergeBasic(getIndex(), o.getIndex(), (Consumer<FloatingRateIndexEnum>) this::addIndex);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndexMap _that = getType().cast(o);
		
			if (!ListEquals.listEquals(index, _that.getIndex())) return false;
			if (!Objects.equals(contractualDefinitionIdentifier, _that.getContractualDefinitionIdentifier())) return false;
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (index != null ? index.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (contractualDefinitionIdentifier != null ? contractualDefinitionIdentifier.hashCode() : 0);
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexMapBuilder {" +
				"index=" + this.index + ", " +
				"contractualDefinitionIdentifier=" + this.contractualDefinitionIdentifier + ", " +
				"identifier=" + this.identifier +
			'}';
		}
	}
}
