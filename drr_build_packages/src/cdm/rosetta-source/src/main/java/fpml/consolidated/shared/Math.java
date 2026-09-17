package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.MathMeta;
import java.util.ArrayList;
import java.util.List;
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
 * Provision A type defining a mathematical expression.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a mathematical expression.
 *
 */
@RosettaDataType(value="Math", builder=Math.MathBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Math", model="fpml", builder=Math.MathBuilderImpl.class, version="2.1.1")
public interface Math extends RosettaModelObject {

	MathMeta metaData = new MathMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Placeholder for xsd:any: Min Occurs: 1; Max Occurs: unbounded; Namespace: ##any; Process Contents: skip.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Placeholder for xsd:any: Min Occurs: 1; Max Occurs: unbounded; Namespace: ##any; Process Contents: skip.
	 *
	 */
	List<String> getAnyContents();

	/*********************** Build Methods  ***********************/
	Math build();
	
	Math.MathBuilder toBuilder();
	
	static Math.MathBuilder builder() {
		return new Math.MathBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Math> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Math> getType() {
		return Math.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MathBuilder extends Math, RosettaModelObjectBuilder {
		Math.MathBuilder addAnyContents(String anyContents);
		Math.MathBuilder addAnyContents(String anyContents, int idx);
		Math.MathBuilder addAnyContents(List<String> anyContents);
		Math.MathBuilder setAnyContents(List<String> anyContents);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
		}
		

		Math.MathBuilder prune();
	}

	/*********************** Immutable Implementation of Math  ***********************/
	class MathImpl implements Math {
		private final List<String> anyContents;
		
		protected MathImpl(Math.MathBuilder builder) {
			this.anyContents = ofNullable(builder.getAnyContents()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("anyContents")
		public List<String> getAnyContents() {
			return anyContents;
		}
		
		@Override
		public Math build() {
			return this;
		}
		
		@Override
		public Math.MathBuilder toBuilder() {
			Math.MathBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Math.MathBuilder builder) {
			ofNullable(getAnyContents()).ifPresent(builder::setAnyContents);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Math _that = getType().cast(o);
		
			if (!ListEquals.listEquals(anyContents, _that.getAnyContents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (anyContents != null ? anyContents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Math {" +
				"anyContents=" + this.anyContents +
			'}';
		}
	}

	/*********************** Builder Implementation of Math  ***********************/
	class MathBuilderImpl implements Math.MathBuilder {
	
		protected List<String> anyContents = new ArrayList<>();
		
		@Override
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("anyContents")
		public List<String> getAnyContents() {
			return anyContents;
		}
		
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("anyContents")
		@Override
		public Math.MathBuilder addAnyContents(String _anyContents) {
			if (_anyContents != null) {
				this.anyContents.add(_anyContents);
			}
			return this;
		}
		
		@Override
		public Math.MathBuilder addAnyContents(String _anyContents, int idx) {
			getIndex(this.anyContents, idx, () -> _anyContents);
			return this;
		}
		
		@Override
		public Math.MathBuilder addAnyContents(List<String> anyContentss) {
			if (anyContentss != null) {
				for (final String toAdd : anyContentss) {
					this.anyContents.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("anyContents")
		@Override
		public Math.MathBuilder setAnyContents(List<String> anyContentss) {
			if (anyContentss == null) {
				this.anyContents = new ArrayList<>();
			} else {
				this.anyContents = anyContentss.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Math build() {
			return new Math.MathImpl(this);
		}
		
		@Override
		public Math.MathBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Math.MathBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAnyContents()!=null && !getAnyContents().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Math.MathBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Math.MathBuilder o = (Math.MathBuilder) other;
			
			
			merger.mergeBasic(getAnyContents(), o.getAnyContents(), (Consumer<String>) this::addAnyContents);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Math _that = getType().cast(o);
		
			if (!ListEquals.listEquals(anyContents, _that.getAnyContents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (anyContents != null ? anyContents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MathBuilder {" +
				"anyContents=" + this.anyContents +
			'}';
		}
	}
}
