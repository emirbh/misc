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
import fpml.consolidated.meta.DSAKeyValueTypeMeta;
import java.util.Objects;

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
@RosettaDataType(value="DSAKeyValueType", builder=DSAKeyValueType.DSAKeyValueTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DSAKeyValueType", model="fpml", builder=DSAKeyValueType.DSAKeyValueTypeBuilderImpl.class, version="2.1.1")
public interface DSAKeyValueType extends RosettaModelObject {

	DSAKeyValueTypeMeta metaData = new DSAKeyValueTypeMeta();

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
	String getP();
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
	String getQ();
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
	String getG();
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
	String getY();
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
	String getJ();
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
	String getSeed();
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
	String getPgenCounter();

	/*********************** Build Methods  ***********************/
	DSAKeyValueType build();
	
	DSAKeyValueType.DSAKeyValueTypeBuilder toBuilder();
	
	static DSAKeyValueType.DSAKeyValueTypeBuilder builder() {
		return new DSAKeyValueType.DSAKeyValueTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DSAKeyValueType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DSAKeyValueType> getType() {
		return DSAKeyValueType.class;
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
	interface DSAKeyValueTypeBuilder extends DSAKeyValueType, RosettaModelObjectBuilder {
		DSAKeyValueType.DSAKeyValueTypeBuilder setP(String p);
		DSAKeyValueType.DSAKeyValueTypeBuilder setQ(String q);
		DSAKeyValueType.DSAKeyValueTypeBuilder setG(String g);
		DSAKeyValueType.DSAKeyValueTypeBuilder setY(String y);
		DSAKeyValueType.DSAKeyValueTypeBuilder setJ(String j);
		DSAKeyValueType.DSAKeyValueTypeBuilder setSeed(String seed);
		DSAKeyValueType.DSAKeyValueTypeBuilder setPgenCounter(String pgenCounter);

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
		

		DSAKeyValueType.DSAKeyValueTypeBuilder prune();
	}

	/*********************** Immutable Implementation of DSAKeyValueType  ***********************/
	class DSAKeyValueTypeImpl implements DSAKeyValueType {
		private final String p;
		private final String q;
		private final String g;
		private final String y;
		private final String j;
		private final String seed;
		private final String pgenCounter;
		
		protected DSAKeyValueTypeImpl(DSAKeyValueType.DSAKeyValueTypeBuilder builder) {
			this.p = builder.getP();
			this.q = builder.getQ();
			this.g = builder.getG();
			this.y = builder.getY();
			this.j = builder.getJ();
			this.seed = builder.getSeed();
			this.pgenCounter = builder.getPgenCounter();
		}
		
		@Override
		@RosettaAttribute("p")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("p")
		public String getP() {
			return p;
		}
		
		@Override
		@RosettaAttribute("q")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("q")
		public String getQ() {
			return q;
		}
		
		@Override
		@RosettaAttribute("g")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("g")
		public String getG() {
			return g;
		}
		
		@Override
		@RosettaAttribute("y")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("y")
		public String getY() {
			return y;
		}
		
		@Override
		@RosettaAttribute("j")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("j")
		public String getJ() {
			return j;
		}
		
		@Override
		@RosettaAttribute("seed")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seed")
		public String getSeed() {
			return seed;
		}
		
		@Override
		@RosettaAttribute("pgenCounter")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pgenCounter")
		public String getPgenCounter() {
			return pgenCounter;
		}
		
		@Override
		public DSAKeyValueType build() {
			return this;
		}
		
		@Override
		public DSAKeyValueType.DSAKeyValueTypeBuilder toBuilder() {
			DSAKeyValueType.DSAKeyValueTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DSAKeyValueType.DSAKeyValueTypeBuilder builder) {
			ofNullable(getP()).ifPresent(builder::setP);
			ofNullable(getQ()).ifPresent(builder::setQ);
			ofNullable(getG()).ifPresent(builder::setG);
			ofNullable(getY()).ifPresent(builder::setY);
			ofNullable(getJ()).ifPresent(builder::setJ);
			ofNullable(getSeed()).ifPresent(builder::setSeed);
			ofNullable(getPgenCounter()).ifPresent(builder::setPgenCounter);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DSAKeyValueType _that = getType().cast(o);
		
			if (!Objects.equals(p, _that.getP())) return false;
			if (!Objects.equals(q, _that.getQ())) return false;
			if (!Objects.equals(g, _that.getG())) return false;
			if (!Objects.equals(y, _that.getY())) return false;
			if (!Objects.equals(j, _that.getJ())) return false;
			if (!Objects.equals(seed, _that.getSeed())) return false;
			if (!Objects.equals(pgenCounter, _that.getPgenCounter())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (p != null ? p.hashCode() : 0);
			_result = 31 * _result + (q != null ? q.hashCode() : 0);
			_result = 31 * _result + (g != null ? g.hashCode() : 0);
			_result = 31 * _result + (y != null ? y.hashCode() : 0);
			_result = 31 * _result + (j != null ? j.hashCode() : 0);
			_result = 31 * _result + (seed != null ? seed.hashCode() : 0);
			_result = 31 * _result + (pgenCounter != null ? pgenCounter.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DSAKeyValueType {" +
				"p=" + this.p + ", " +
				"q=" + this.q + ", " +
				"g=" + this.g + ", " +
				"y=" + this.y + ", " +
				"j=" + this.j + ", " +
				"seed=" + this.seed + ", " +
				"pgenCounter=" + this.pgenCounter +
			'}';
		}
	}

	/*********************** Builder Implementation of DSAKeyValueType  ***********************/
	class DSAKeyValueTypeBuilderImpl implements DSAKeyValueType.DSAKeyValueTypeBuilder {
	
		protected String p;
		protected String q;
		protected String g;
		protected String y;
		protected String j;
		protected String seed;
		protected String pgenCounter;
		
		@Override
		@RosettaAttribute("p")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("p")
		public String getP() {
			return p;
		}
		
		@Override
		@RosettaAttribute("q")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("q")
		public String getQ() {
			return q;
		}
		
		@Override
		@RosettaAttribute("g")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("g")
		public String getG() {
			return g;
		}
		
		@Override
		@RosettaAttribute("y")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("y")
		public String getY() {
			return y;
		}
		
		@Override
		@RosettaAttribute("j")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("j")
		public String getJ() {
			return j;
		}
		
		@Override
		@RosettaAttribute("seed")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("seed")
		public String getSeed() {
			return seed;
		}
		
		@Override
		@RosettaAttribute("pgenCounter")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pgenCounter")
		public String getPgenCounter() {
			return pgenCounter;
		}
		
		@RosettaAttribute("p")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("p")
		@Override
		public DSAKeyValueType.DSAKeyValueTypeBuilder setP(String _p) {
			this.p = _p == null ? null : _p;
			return this;
		}
		
		@RosettaAttribute("q")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("q")
		@Override
		public DSAKeyValueType.DSAKeyValueTypeBuilder setQ(String _q) {
			this.q = _q == null ? null : _q;
			return this;
		}
		
		@RosettaAttribute("g")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("g")
		@Override
		public DSAKeyValueType.DSAKeyValueTypeBuilder setG(String _g) {
			this.g = _g == null ? null : _g;
			return this;
		}
		
		@RosettaAttribute("y")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("y")
		@Override
		public DSAKeyValueType.DSAKeyValueTypeBuilder setY(String _y) {
			this.y = _y == null ? null : _y;
			return this;
		}
		
		@RosettaAttribute("j")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("j")
		@Override
		public DSAKeyValueType.DSAKeyValueTypeBuilder setJ(String _j) {
			this.j = _j == null ? null : _j;
			return this;
		}
		
		@RosettaAttribute("seed")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("seed")
		@Override
		public DSAKeyValueType.DSAKeyValueTypeBuilder setSeed(String _seed) {
			this.seed = _seed == null ? null : _seed;
			return this;
		}
		
		@RosettaAttribute("pgenCounter")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pgenCounter")
		@Override
		public DSAKeyValueType.DSAKeyValueTypeBuilder setPgenCounter(String _pgenCounter) {
			this.pgenCounter = _pgenCounter == null ? null : _pgenCounter;
			return this;
		}
		
		@Override
		public DSAKeyValueType build() {
			return new DSAKeyValueType.DSAKeyValueTypeImpl(this);
		}
		
		@Override
		public DSAKeyValueType.DSAKeyValueTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DSAKeyValueType.DSAKeyValueTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getP()!=null) return true;
			if (getQ()!=null) return true;
			if (getG()!=null) return true;
			if (getY()!=null) return true;
			if (getJ()!=null) return true;
			if (getSeed()!=null) return true;
			if (getPgenCounter()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DSAKeyValueType.DSAKeyValueTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DSAKeyValueType.DSAKeyValueTypeBuilder o = (DSAKeyValueType.DSAKeyValueTypeBuilder) other;
			
			
			merger.mergeBasic(getP(), o.getP(), this::setP);
			merger.mergeBasic(getQ(), o.getQ(), this::setQ);
			merger.mergeBasic(getG(), o.getG(), this::setG);
			merger.mergeBasic(getY(), o.getY(), this::setY);
			merger.mergeBasic(getJ(), o.getJ(), this::setJ);
			merger.mergeBasic(getSeed(), o.getSeed(), this::setSeed);
			merger.mergeBasic(getPgenCounter(), o.getPgenCounter(), this::setPgenCounter);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DSAKeyValueType _that = getType().cast(o);
		
			if (!Objects.equals(p, _that.getP())) return false;
			if (!Objects.equals(q, _that.getQ())) return false;
			if (!Objects.equals(g, _that.getG())) return false;
			if (!Objects.equals(y, _that.getY())) return false;
			if (!Objects.equals(j, _that.getJ())) return false;
			if (!Objects.equals(seed, _that.getSeed())) return false;
			if (!Objects.equals(pgenCounter, _that.getPgenCounter())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (p != null ? p.hashCode() : 0);
			_result = 31 * _result + (q != null ? q.hashCode() : 0);
			_result = 31 * _result + (g != null ? g.hashCode() : 0);
			_result = 31 * _result + (y != null ? y.hashCode() : 0);
			_result = 31 * _result + (j != null ? j.hashCode() : 0);
			_result = 31 * _result + (seed != null ? seed.hashCode() : 0);
			_result = 31 * _result + (pgenCounter != null ? pgenCounter.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DSAKeyValueTypeBuilder {" +
				"p=" + this.p + ", " +
				"q=" + this.q + ", " +
				"g=" + this.g + ", " +
				"y=" + this.y + ", " +
				"j=" + this.j + ", " +
				"seed=" + this.seed + ", " +
				"pgenCounter=" + this.pgenCounter +
			'}';
		}
	}
}
