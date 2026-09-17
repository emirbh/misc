package fpml.consolidated;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.meta.DSAKeyValueMeta;


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
@RosettaDataType(value="DSAKeyValue", builder=DSAKeyValue.DSAKeyValueBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DSAKeyValue", model="fpml", builder=DSAKeyValue.DSAKeyValueBuilderImpl.class, version="2.1.1")
public interface DSAKeyValue extends DSAKeyValueType {

	DSAKeyValueMeta metaData = new DSAKeyValueMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	DSAKeyValue build();
	
	DSAKeyValue.DSAKeyValueBuilder toBuilder();
	
	static DSAKeyValue.DSAKeyValueBuilder builder() {
		return new DSAKeyValue.DSAKeyValueBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DSAKeyValue> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DSAKeyValue> getType() {
		return DSAKeyValue.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("p"), String.class, getP(), this);
		processor.processBasic(path.newSubPath("q"), String.class, getQ(), this);
		processor.processBasic(path.newSubPath("g"), String.class, getG(), this);
		processor.processBasic(path.newSubPath("y"), String.class, getY(), this);
		processor.processBasic(path.newSubPath("j"), String.class, getJ(), this);
		processor.processBasic(path.newSubPath("seed"), String.class, getSeed(), this);
		processor.processBasic(path.newSubPath("pgenCounter"), String.class, getPgenCounter(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DSAKeyValueBuilder extends DSAKeyValue, DSAKeyValueType.DSAKeyValueTypeBuilder {
		@Override
		DSAKeyValue.DSAKeyValueBuilder setP(String p);
		@Override
		DSAKeyValue.DSAKeyValueBuilder setQ(String q);
		@Override
		DSAKeyValue.DSAKeyValueBuilder setG(String g);
		@Override
		DSAKeyValue.DSAKeyValueBuilder setY(String y);
		@Override
		DSAKeyValue.DSAKeyValueBuilder setJ(String j);
		@Override
		DSAKeyValue.DSAKeyValueBuilder setSeed(String seed);
		@Override
		DSAKeyValue.DSAKeyValueBuilder setPgenCounter(String pgenCounter);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("p"), String.class, getP(), this);
			processor.processBasic(path.newSubPath("q"), String.class, getQ(), this);
			processor.processBasic(path.newSubPath("g"), String.class, getG(), this);
			processor.processBasic(path.newSubPath("y"), String.class, getY(), this);
			processor.processBasic(path.newSubPath("j"), String.class, getJ(), this);
			processor.processBasic(path.newSubPath("seed"), String.class, getSeed(), this);
			processor.processBasic(path.newSubPath("pgenCounter"), String.class, getPgenCounter(), this);
		}
		

		DSAKeyValue.DSAKeyValueBuilder prune();
	}

	/*********************** Immutable Implementation of DSAKeyValue  ***********************/
	class DSAKeyValueImpl extends DSAKeyValueType.DSAKeyValueTypeImpl implements DSAKeyValue {
		
		protected DSAKeyValueImpl(DSAKeyValue.DSAKeyValueBuilder builder) {
			super(builder);
		}
		
		@Override
		public DSAKeyValue build() {
			return this;
		}
		
		@Override
		public DSAKeyValue.DSAKeyValueBuilder toBuilder() {
			DSAKeyValue.DSAKeyValueBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DSAKeyValue.DSAKeyValueBuilder builder) {
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
			return "DSAKeyValue {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DSAKeyValue  ***********************/
	class DSAKeyValueBuilderImpl extends DSAKeyValueType.DSAKeyValueTypeBuilderImpl implements DSAKeyValue.DSAKeyValueBuilder {
	
		
		@RosettaAttribute("p")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("p")
		@Override
		public DSAKeyValue.DSAKeyValueBuilder setP(String _p) {
			this.p = _p == null ? null : _p;
			return this;
		}
		
		@RosettaAttribute("q")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("q")
		@Override
		public DSAKeyValue.DSAKeyValueBuilder setQ(String _q) {
			this.q = _q == null ? null : _q;
			return this;
		}
		
		@RosettaAttribute("g")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("g")
		@Override
		public DSAKeyValue.DSAKeyValueBuilder setG(String _g) {
			this.g = _g == null ? null : _g;
			return this;
		}
		
		@RosettaAttribute("y")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("y")
		@Override
		public DSAKeyValue.DSAKeyValueBuilder setY(String _y) {
			this.y = _y == null ? null : _y;
			return this;
		}
		
		@RosettaAttribute("j")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("j")
		@Override
		public DSAKeyValue.DSAKeyValueBuilder setJ(String _j) {
			this.j = _j == null ? null : _j;
			return this;
		}
		
		@RosettaAttribute("seed")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seed")
		@Override
		public DSAKeyValue.DSAKeyValueBuilder setSeed(String _seed) {
			this.seed = _seed == null ? null : _seed;
			return this;
		}
		
		@RosettaAttribute("pgenCounter")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pgenCounter")
		@Override
		public DSAKeyValue.DSAKeyValueBuilder setPgenCounter(String _pgenCounter) {
			this.pgenCounter = _pgenCounter == null ? null : _pgenCounter;
			return this;
		}
		
		@Override
		public DSAKeyValue build() {
			return new DSAKeyValue.DSAKeyValueImpl(this);
		}
		
		@Override
		public DSAKeyValue.DSAKeyValueBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DSAKeyValue.DSAKeyValueBuilder prune() {
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
		public DSAKeyValue.DSAKeyValueBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			DSAKeyValue.DSAKeyValueBuilder o = (DSAKeyValue.DSAKeyValueBuilder) other;
			
			
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
			return "DSAKeyValueBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
