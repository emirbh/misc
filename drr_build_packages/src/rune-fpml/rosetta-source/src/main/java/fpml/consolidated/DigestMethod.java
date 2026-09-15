package fpml.consolidated;

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
import fpml.consolidated.meta.DigestMethodMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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
@RosettaDataType(value="DigestMethod", builder=DigestMethod.DigestMethodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DigestMethod", model="fpml", builder=DigestMethod.DigestMethodBuilderImpl.class, version="2.1.1")
public interface DigestMethod extends DigestMethodType {

	DigestMethodMeta metaData = new DigestMethodMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	DigestMethod build();
	
	DigestMethod.DigestMethodBuilder toBuilder();
	
	static DigestMethod.DigestMethodBuilder builder() {
		return new DigestMethod.DigestMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DigestMethod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DigestMethod> getType() {
		return DigestMethod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
		processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DigestMethodBuilder extends DigestMethod, DigestMethodType.DigestMethodTypeBuilder {
		@Override
		DigestMethod.DigestMethodBuilder setAlgorithm(String algorithm);
		@Override
		DigestMethod.DigestMethodBuilder addAnyContents(String anyContents);
		@Override
		DigestMethod.DigestMethodBuilder addAnyContents(String anyContents, int idx);
		@Override
		DigestMethod.DigestMethodBuilder addAnyContents(List<String> anyContents);
		@Override
		DigestMethod.DigestMethodBuilder setAnyContents(List<String> anyContents);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
			processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
		}
		

		DigestMethod.DigestMethodBuilder prune();
	}

	/*********************** Immutable Implementation of DigestMethod  ***********************/
	class DigestMethodImpl extends DigestMethodType.DigestMethodTypeImpl implements DigestMethod {
		
		protected DigestMethodImpl(DigestMethod.DigestMethodBuilder builder) {
			super(builder);
		}
		
		@Override
		public DigestMethod build() {
			return this;
		}
		
		@Override
		public DigestMethod.DigestMethodBuilder toBuilder() {
			DigestMethod.DigestMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DigestMethod.DigestMethodBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "DigestMethod {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DigestMethod  ***********************/
	class DigestMethodBuilderImpl extends DigestMethodType.DigestMethodTypeBuilderImpl implements DigestMethod.DigestMethodBuilder {
	
		
		@RosettaAttribute("algorithm")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("algorithm")
		@Override
		public DigestMethod.DigestMethodBuilder setAlgorithm(String _algorithm) {
			this.algorithm = _algorithm == null ? null : _algorithm;
			return this;
		}
		
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("anyContents")
		@Override
		public DigestMethod.DigestMethodBuilder addAnyContents(String _anyContents) {
			if (_anyContents != null) {
				this.anyContents.add(_anyContents);
			}
			return this;
		}
		
		@Override
		public DigestMethod.DigestMethodBuilder addAnyContents(String _anyContents, int idx) {
			getIndex(this.anyContents, idx, () -> _anyContents);
			return this;
		}
		
		@Override
		public DigestMethod.DigestMethodBuilder addAnyContents(List<String> anyContentss) {
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
		public DigestMethod.DigestMethodBuilder setAnyContents(List<String> anyContentss) {
			if (anyContentss == null) {
				this.anyContents = new ArrayList<>();
			} else {
				this.anyContents = anyContentss.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public DigestMethod build() {
			return new DigestMethod.DigestMethodImpl(this);
		}
		
		@Override
		public DigestMethod.DigestMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DigestMethod.DigestMethodBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DigestMethod.DigestMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			DigestMethod.DigestMethodBuilder o = (DigestMethod.DigestMethodBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "DigestMethodBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
