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
import fpml.consolidated.meta.CanonicalizationMethodMeta;
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
@RosettaDataType(value="CanonicalizationMethod", builder=CanonicalizationMethod.CanonicalizationMethodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CanonicalizationMethod", model="fpml", builder=CanonicalizationMethod.CanonicalizationMethodBuilderImpl.class, version="2.1.1")
public interface CanonicalizationMethod extends CanonicalizationMethodType {

	CanonicalizationMethodMeta metaData = new CanonicalizationMethodMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	CanonicalizationMethod build();
	
	CanonicalizationMethod.CanonicalizationMethodBuilder toBuilder();
	
	static CanonicalizationMethod.CanonicalizationMethodBuilder builder() {
		return new CanonicalizationMethod.CanonicalizationMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CanonicalizationMethod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CanonicalizationMethod> getType() {
		return CanonicalizationMethod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
		processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CanonicalizationMethodBuilder extends CanonicalizationMethod, CanonicalizationMethodType.CanonicalizationMethodTypeBuilder {
		@Override
		CanonicalizationMethod.CanonicalizationMethodBuilder setAlgorithm(String algorithm);
		@Override
		CanonicalizationMethod.CanonicalizationMethodBuilder addAnyContents(String anyContents);
		@Override
		CanonicalizationMethod.CanonicalizationMethodBuilder addAnyContents(String anyContents, int idx);
		@Override
		CanonicalizationMethod.CanonicalizationMethodBuilder addAnyContents(List<String> anyContents);
		@Override
		CanonicalizationMethod.CanonicalizationMethodBuilder setAnyContents(List<String> anyContents);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("algorithm"), String.class, getAlgorithm(), this);
			processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
		}
		

		CanonicalizationMethod.CanonicalizationMethodBuilder prune();
	}

	/*********************** Immutable Implementation of CanonicalizationMethod  ***********************/
	class CanonicalizationMethodImpl extends CanonicalizationMethodType.CanonicalizationMethodTypeImpl implements CanonicalizationMethod {
		
		protected CanonicalizationMethodImpl(CanonicalizationMethod.CanonicalizationMethodBuilder builder) {
			super(builder);
		}
		
		@Override
		public CanonicalizationMethod build() {
			return this;
		}
		
		@Override
		public CanonicalizationMethod.CanonicalizationMethodBuilder toBuilder() {
			CanonicalizationMethod.CanonicalizationMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CanonicalizationMethod.CanonicalizationMethodBuilder builder) {
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
			return "CanonicalizationMethod {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CanonicalizationMethod  ***********************/
	class CanonicalizationMethodBuilderImpl extends CanonicalizationMethodType.CanonicalizationMethodTypeBuilderImpl implements CanonicalizationMethod.CanonicalizationMethodBuilder {
	
		
		@RosettaAttribute("algorithm")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("algorithm")
		@Override
		public CanonicalizationMethod.CanonicalizationMethodBuilder setAlgorithm(String _algorithm) {
			this.algorithm = _algorithm == null ? null : _algorithm;
			return this;
		}
		
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("anyContents")
		@Override
		public CanonicalizationMethod.CanonicalizationMethodBuilder addAnyContents(String _anyContents) {
			if (_anyContents != null) {
				this.anyContents.add(_anyContents);
			}
			return this;
		}
		
		@Override
		public CanonicalizationMethod.CanonicalizationMethodBuilder addAnyContents(String _anyContents, int idx) {
			getIndex(this.anyContents, idx, () -> _anyContents);
			return this;
		}
		
		@Override
		public CanonicalizationMethod.CanonicalizationMethodBuilder addAnyContents(List<String> anyContentss) {
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
		public CanonicalizationMethod.CanonicalizationMethodBuilder setAnyContents(List<String> anyContentss) {
			if (anyContentss == null) {
				this.anyContents = new ArrayList<>();
			} else {
				this.anyContents = anyContentss.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CanonicalizationMethod build() {
			return new CanonicalizationMethod.CanonicalizationMethodImpl(this);
		}
		
		@Override
		public CanonicalizationMethod.CanonicalizationMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CanonicalizationMethod.CanonicalizationMethodBuilder prune() {
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
		public CanonicalizationMethod.CanonicalizationMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CanonicalizationMethod.CanonicalizationMethodBuilder o = (CanonicalizationMethod.CanonicalizationMethodBuilder) other;
			
			
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
			return "CanonicalizationMethodBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
