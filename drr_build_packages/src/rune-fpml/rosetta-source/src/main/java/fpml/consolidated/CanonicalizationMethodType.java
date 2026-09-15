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
import fpml.consolidated.meta.CanonicalizationMethodTypeMeta;
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
@RosettaDataType(value="CanonicalizationMethodType", builder=CanonicalizationMethodType.CanonicalizationMethodTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CanonicalizationMethodType", model="fpml", builder=CanonicalizationMethodType.CanonicalizationMethodTypeBuilderImpl.class, version="2.1.1")
public interface CanonicalizationMethodType extends RosettaModelObject {

	CanonicalizationMethodTypeMeta metaData = new CanonicalizationMethodTypeMeta();

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
	 * Provision Placeholder for xsd:any: Min Occurs: 0; Max Occurs: unbounded; Namespace: ##any; Process Contents: strict.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Placeholder for xsd:any: Min Occurs: 0; Max Occurs: unbounded; Namespace: ##any; Process Contents: strict.
	 *
	 */
	List<String> getAnyContents();

	/*********************** Build Methods  ***********************/
	CanonicalizationMethodType build();
	
	CanonicalizationMethodType.CanonicalizationMethodTypeBuilder toBuilder();
	
	static CanonicalizationMethodType.CanonicalizationMethodTypeBuilder builder() {
		return new CanonicalizationMethodType.CanonicalizationMethodTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CanonicalizationMethodType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CanonicalizationMethodType> getType() {
		return CanonicalizationMethodType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
		processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CanonicalizationMethodTypeBuilder extends CanonicalizationMethodType, RosettaModelObjectBuilder {
		CanonicalizationMethodType.CanonicalizationMethodTypeBuilder setAlgorithm(String algorithm);
		CanonicalizationMethodType.CanonicalizationMethodTypeBuilder addAnyContents(String anyContents);
		CanonicalizationMethodType.CanonicalizationMethodTypeBuilder addAnyContents(String anyContents, int idx);
		CanonicalizationMethodType.CanonicalizationMethodTypeBuilder addAnyContents(List<String> anyContents);
		CanonicalizationMethodType.CanonicalizationMethodTypeBuilder setAnyContents(List<String> anyContents);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
			processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
		}
		

		CanonicalizationMethodType.CanonicalizationMethodTypeBuilder prune();
	}

	/*********************** Immutable Implementation of CanonicalizationMethodType  ***********************/
	class CanonicalizationMethodTypeImpl implements CanonicalizationMethodType {
		private final String algorithm;
		private final List<String> anyContents;
		
		protected CanonicalizationMethodTypeImpl(CanonicalizationMethodType.CanonicalizationMethodTypeBuilder builder) {
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
		public CanonicalizationMethodType build() {
			return this;
		}
		
		@Override
		public CanonicalizationMethodType.CanonicalizationMethodTypeBuilder toBuilder() {
			CanonicalizationMethodType.CanonicalizationMethodTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CanonicalizationMethodType.CanonicalizationMethodTypeBuilder builder) {
			ofNullable(getAlgorithm()).ifPresent(builder::setAlgorithm);
			ofNullable(getAnyContents()).ifPresent(builder::setAnyContents);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CanonicalizationMethodType _that = getType().cast(o);
		
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
			return "CanonicalizationMethodType {" +
				"algorithm=" + this.algorithm + ", " +
				"anyContents=" + this.anyContents +
			'}';
		}
	}

	/*********************** Builder Implementation of CanonicalizationMethodType  ***********************/
	class CanonicalizationMethodTypeBuilderImpl implements CanonicalizationMethodType.CanonicalizationMethodTypeBuilder {
	
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
		public CanonicalizationMethodType.CanonicalizationMethodTypeBuilder setAlgorithm(String _algorithm) {
			this.algorithm = _algorithm == null ? null : _algorithm;
			return this;
		}
		
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("anyContents")
		@Override
		public CanonicalizationMethodType.CanonicalizationMethodTypeBuilder addAnyContents(String _anyContents) {
			if (_anyContents != null) {
				this.anyContents.add(_anyContents);
			}
			return this;
		}
		
		@Override
		public CanonicalizationMethodType.CanonicalizationMethodTypeBuilder addAnyContents(String _anyContents, int idx) {
			getIndex(this.anyContents, idx, () -> _anyContents);
			return this;
		}
		
		@Override
		public CanonicalizationMethodType.CanonicalizationMethodTypeBuilder addAnyContents(List<String> anyContentss) {
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
		public CanonicalizationMethodType.CanonicalizationMethodTypeBuilder setAnyContents(List<String> anyContentss) {
			if (anyContentss == null) {
				this.anyContents = new ArrayList<>();
			} else {
				this.anyContents = anyContentss.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CanonicalizationMethodType build() {
			return new CanonicalizationMethodType.CanonicalizationMethodTypeImpl(this);
		}
		
		@Override
		public CanonicalizationMethodType.CanonicalizationMethodTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CanonicalizationMethodType.CanonicalizationMethodTypeBuilder prune() {
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
		public CanonicalizationMethodType.CanonicalizationMethodTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CanonicalizationMethodType.CanonicalizationMethodTypeBuilder o = (CanonicalizationMethodType.CanonicalizationMethodTypeBuilder) other;
			
			
			merger.mergeBasic(getAlgorithm(), o.getAlgorithm(), this::setAlgorithm);
			merger.mergeBasic(getAnyContents(), o.getAnyContents(), (Consumer<String>) this::addAnyContents);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CanonicalizationMethodType _that = getType().cast(o);
		
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
			return "CanonicalizationMethodTypeBuilder {" +
				"algorithm=" + this.algorithm + ", " +
				"anyContents=" + this.anyContents +
			'}';
		}
	}
}
