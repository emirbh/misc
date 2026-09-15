package fpml.consolidated;

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
import fpml.consolidated.meta.DigestMethodTypeMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="DigestMethodType", builder=DigestMethodType.DigestMethodTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DigestMethodType", model="fpml", builder=DigestMethodType.DigestMethodTypeBuilderImpl.class, version="2.1.1")
public interface DigestMethodType extends RosettaModelObject {

	DigestMethodTypeMeta metaData = new DigestMethodTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getAlgorithm();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Placeholder for xsd:any: Min Occurs: 0; Max Occurs: unbounded; Namespace: ##other; Process Contents: lax.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Placeholder for xsd:any: Min Occurs: 0; Max Occurs: unbounded; Namespace: ##other; Process Contents: lax.
	 *
	 */
	List<String> getAnyContents();

	/*********************** Build Methods  ***********************/
	DigestMethodType build();
	
	DigestMethodType.DigestMethodTypeBuilder toBuilder();
	
	static DigestMethodType.DigestMethodTypeBuilder builder() {
		return new DigestMethodType.DigestMethodTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DigestMethodType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DigestMethodType> getType() {
		return DigestMethodType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
		processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DigestMethodTypeBuilder extends DigestMethodType, RosettaModelObjectBuilder {
		DigestMethodType.DigestMethodTypeBuilder setAlgorithm(String algorithm);
		DigestMethodType.DigestMethodTypeBuilder addAnyContents(String anyContents);
		DigestMethodType.DigestMethodTypeBuilder addAnyContents(String anyContents, int idx);
		DigestMethodType.DigestMethodTypeBuilder addAnyContents(List<String> anyContents);
		DigestMethodType.DigestMethodTypeBuilder setAnyContents(List<String> anyContents);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
			processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
		}
		

		DigestMethodType.DigestMethodTypeBuilder prune();
	}

	/*********************** Immutable Implementation of DigestMethodType  ***********************/
	class DigestMethodTypeImpl implements DigestMethodType {
		private final String algorithm;
		private final List<String> anyContents;
		
		protected DigestMethodTypeImpl(DigestMethodType.DigestMethodTypeBuilder builder) {
			this.algorithm = builder.getAlgorithm();
			this.anyContents = ofNullable(builder.getAnyContents()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("algorithm")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("algorithm")
		public String getAlgorithm() {
			return algorithm;
		}
		
		@Override
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("anyContents")
		public List<String> getAnyContents() {
			return anyContents;
		}
		
		@Override
		public DigestMethodType build() {
			return this;
		}
		
		@Override
		public DigestMethodType.DigestMethodTypeBuilder toBuilder() {
			DigestMethodType.DigestMethodTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DigestMethodType.DigestMethodTypeBuilder builder) {
			ofNullable(getAlgorithm()).ifPresent(builder::setAlgorithm);
			ofNullable(getAnyContents()).ifPresent(builder::setAnyContents);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DigestMethodType _that = getType().cast(o);
		
			if (!Objects.equals(algorithm, _that.getAlgorithm())) return false;
			if (!ListEquals.listEquals(anyContents, _that.getAnyContents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (algorithm != null ? algorithm.hashCode() : 0);
			_result = 31 * _result + (anyContents != null ? anyContents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DigestMethodType {" +
				"algorithm=" + this.algorithm + ", " +
				"anyContents=" + this.anyContents +
			'}';
		}
	}

	/*********************** Builder Implementation of DigestMethodType  ***********************/
	class DigestMethodTypeBuilderImpl implements DigestMethodType.DigestMethodTypeBuilder {
	
		protected String algorithm;
		protected List<String> anyContents = new ArrayList<>();
		
		@Override
		@RosettaAttribute("algorithm")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("algorithm")
		public String getAlgorithm() {
			return algorithm;
		}
		
		@Override
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("anyContents")
		public List<String> getAnyContents() {
			return anyContents;
		}
		
		@RosettaAttribute("algorithm")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("algorithm")
		@Override
		public DigestMethodType.DigestMethodTypeBuilder setAlgorithm(String _algorithm) {
			this.algorithm = _algorithm == null ? null : _algorithm;
			return this;
		}
		
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("anyContents")
		@Override
		public DigestMethodType.DigestMethodTypeBuilder addAnyContents(String _anyContents) {
			if (_anyContents != null) {
				this.anyContents.add(_anyContents);
			}
			return this;
		}
		
		@Override
		public DigestMethodType.DigestMethodTypeBuilder addAnyContents(String _anyContents, int idx) {
			getIndex(this.anyContents, idx, () -> _anyContents);
			return this;
		}
		
		@Override
		public DigestMethodType.DigestMethodTypeBuilder addAnyContents(List<String> anyContentss) {
			if (anyContentss != null) {
				for (final String toAdd : anyContentss) {
					this.anyContents.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("anyContents")
		@Override
		public DigestMethodType.DigestMethodTypeBuilder setAnyContents(List<String> anyContentss) {
			if (anyContentss == null) {
				this.anyContents = new ArrayList<>();
			} else {
				this.anyContents = anyContentss.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public DigestMethodType build() {
			return new DigestMethodType.DigestMethodTypeImpl(this);
		}
		
		@Override
		public DigestMethodType.DigestMethodTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DigestMethodType.DigestMethodTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAlgorithm()!=null) return true;
			if (getAnyContents()!=null && !getAnyContents().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DigestMethodType.DigestMethodTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DigestMethodType.DigestMethodTypeBuilder o = (DigestMethodType.DigestMethodTypeBuilder) other;
			
			
			merger.mergeBasic(getAlgorithm(), o.getAlgorithm(), this::setAlgorithm);
			merger.mergeBasic(getAnyContents(), o.getAnyContents(), (Consumer<String>) this::addAnyContents);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DigestMethodType _that = getType().cast(o);
		
			if (!Objects.equals(algorithm, _that.getAlgorithm())) return false;
			if (!ListEquals.listEquals(anyContents, _that.getAnyContents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (algorithm != null ? algorithm.hashCode() : 0);
			_result = 31 * _result + (anyContents != null ? anyContents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DigestMethodTypeBuilder {" +
				"algorithm=" + this.algorithm + ", " +
				"anyContents=" + this.anyContents +
			'}';
		}
	}
}
