package fpml.consolidated;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.meta.X509DataTypeSequenceMeta;
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
@RosettaDataType(value="X509DataTypeSequence", builder=X509DataTypeSequence.X509DataTypeSequenceBuilderImpl.class, version="2.1.1")
@RuneDataType(value="X509DataTypeSequence", model="fpml", builder=X509DataTypeSequence.X509DataTypeSequenceBuilderImpl.class, version="2.1.1")
public interface X509DataTypeSequence extends RosettaModelObject {

	X509DataTypeSequenceMeta metaData = new X509DataTypeSequenceMeta();

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
	X509IssuerSerialType getX509IssuerSerial();
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
	String getX509SKI();
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
	String getX509SubjectName();
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
	String getX509Certificate();
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
	String getX509CRL();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Placeholder for xsd:any: Min Occurs: 1; Max Occurs: 1; Namespace: ##other; Process Contents: lax.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Placeholder for xsd:any: Min Occurs: 1; Max Occurs: 1; Namespace: ##other; Process Contents: lax.
	 *
	 */
	String getAnyContents();

	/*********************** Build Methods  ***********************/
	X509DataTypeSequence build();
	
	X509DataTypeSequence.X509DataTypeSequenceBuilder toBuilder();
	
	static X509DataTypeSequence.X509DataTypeSequenceBuilder builder() {
		return new X509DataTypeSequence.X509DataTypeSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends X509DataTypeSequence> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends X509DataTypeSequence> getType() {
		return X509DataTypeSequence.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("x509IssuerSerial"), processor, X509IssuerSerialType.class, getX509IssuerSerial());
		processor.processBasic(path.newSubPath("x509SKI"), String.class, getX509SKI(), this);
		processor.processBasic(path.newSubPath("x509SubjectName"), String.class, getX509SubjectName(), this);
		processor.processBasic(path.newSubPath("x509Certificate"), String.class, getX509Certificate(), this);
		processor.processBasic(path.newSubPath("x509CRL"), String.class, getX509CRL(), this);
		processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface X509DataTypeSequenceBuilder extends X509DataTypeSequence, RosettaModelObjectBuilder {
		X509IssuerSerialType.X509IssuerSerialTypeBuilder getOrCreateX509IssuerSerial();
		@Override
		X509IssuerSerialType.X509IssuerSerialTypeBuilder getX509IssuerSerial();
		X509DataTypeSequence.X509DataTypeSequenceBuilder setX509IssuerSerial(X509IssuerSerialType x509IssuerSerial);
		X509DataTypeSequence.X509DataTypeSequenceBuilder setX509SKI(String x509SKI);
		X509DataTypeSequence.X509DataTypeSequenceBuilder setX509SubjectName(String x509SubjectName);
		X509DataTypeSequence.X509DataTypeSequenceBuilder setX509Certificate(String x509Certificate);
		X509DataTypeSequence.X509DataTypeSequenceBuilder setX509CRL(String x509CRL);
		X509DataTypeSequence.X509DataTypeSequenceBuilder setAnyContents(String anyContents);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("x509IssuerSerial"), processor, X509IssuerSerialType.X509IssuerSerialTypeBuilder.class, getX509IssuerSerial());
			processor.processBasic(path.newSubPath("x509SKI"), String.class, getX509SKI(), this);
			processor.processBasic(path.newSubPath("x509SubjectName"), String.class, getX509SubjectName(), this);
			processor.processBasic(path.newSubPath("x509Certificate"), String.class, getX509Certificate(), this);
			processor.processBasic(path.newSubPath("x509CRL"), String.class, getX509CRL(), this);
			processor.processBasic(path.newSubPath("anyContents"), String.class, getAnyContents(), this);
		}
		

		X509DataTypeSequence.X509DataTypeSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of X509DataTypeSequence  ***********************/
	class X509DataTypeSequenceImpl implements X509DataTypeSequence {
		private final X509IssuerSerialType x509IssuerSerial;
		private final String x509SKI;
		private final String x509SubjectName;
		private final String x509Certificate;
		private final String x509CRL;
		private final String anyContents;
		
		protected X509DataTypeSequenceImpl(X509DataTypeSequence.X509DataTypeSequenceBuilder builder) {
			this.x509IssuerSerial = ofNullable(builder.getX509IssuerSerial()).map(f->f.build()).orElse(null);
			this.x509SKI = builder.getX509SKI();
			this.x509SubjectName = builder.getX509SubjectName();
			this.x509Certificate = builder.getX509Certificate();
			this.x509CRL = builder.getX509CRL();
			this.anyContents = builder.getAnyContents();
		}
		
		@Override
		@RosettaAttribute("x509IssuerSerial")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("x509IssuerSerial")
		public X509IssuerSerialType getX509IssuerSerial() {
			return x509IssuerSerial;
		}
		
		@Override
		@RosettaAttribute("x509SKI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("x509SKI")
		public String getX509SKI() {
			return x509SKI;
		}
		
		@Override
		@RosettaAttribute("x509SubjectName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("x509SubjectName")
		public String getX509SubjectName() {
			return x509SubjectName;
		}
		
		@Override
		@RosettaAttribute("x509Certificate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("x509Certificate")
		public String getX509Certificate() {
			return x509Certificate;
		}
		
		@Override
		@RosettaAttribute("x509CRL")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("x509CRL")
		public String getX509CRL() {
			return x509CRL;
		}
		
		@Override
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("anyContents")
		public String getAnyContents() {
			return anyContents;
		}
		
		@Override
		public X509DataTypeSequence build() {
			return this;
		}
		
		@Override
		public X509DataTypeSequence.X509DataTypeSequenceBuilder toBuilder() {
			X509DataTypeSequence.X509DataTypeSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(X509DataTypeSequence.X509DataTypeSequenceBuilder builder) {
			ofNullable(getX509IssuerSerial()).ifPresent(builder::setX509IssuerSerial);
			ofNullable(getX509SKI()).ifPresent(builder::setX509SKI);
			ofNullable(getX509SubjectName()).ifPresent(builder::setX509SubjectName);
			ofNullable(getX509Certificate()).ifPresent(builder::setX509Certificate);
			ofNullable(getX509CRL()).ifPresent(builder::setX509CRL);
			ofNullable(getAnyContents()).ifPresent(builder::setAnyContents);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			X509DataTypeSequence _that = getType().cast(o);
		
			if (!Objects.equals(x509IssuerSerial, _that.getX509IssuerSerial())) return false;
			if (!Objects.equals(x509SKI, _that.getX509SKI())) return false;
			if (!Objects.equals(x509SubjectName, _that.getX509SubjectName())) return false;
			if (!Objects.equals(x509Certificate, _that.getX509Certificate())) return false;
			if (!Objects.equals(x509CRL, _that.getX509CRL())) return false;
			if (!Objects.equals(anyContents, _that.getAnyContents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (x509IssuerSerial != null ? x509IssuerSerial.hashCode() : 0);
			_result = 31 * _result + (x509SKI != null ? x509SKI.hashCode() : 0);
			_result = 31 * _result + (x509SubjectName != null ? x509SubjectName.hashCode() : 0);
			_result = 31 * _result + (x509Certificate != null ? x509Certificate.hashCode() : 0);
			_result = 31 * _result + (x509CRL != null ? x509CRL.hashCode() : 0);
			_result = 31 * _result + (anyContents != null ? anyContents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "X509DataTypeSequence {" +
				"x509IssuerSerial=" + this.x509IssuerSerial + ", " +
				"x509SKI=" + this.x509SKI + ", " +
				"x509SubjectName=" + this.x509SubjectName + ", " +
				"x509Certificate=" + this.x509Certificate + ", " +
				"x509CRL=" + this.x509CRL + ", " +
				"anyContents=" + this.anyContents +
			'}';
		}
	}

	/*********************** Builder Implementation of X509DataTypeSequence  ***********************/
	class X509DataTypeSequenceBuilderImpl implements X509DataTypeSequence.X509DataTypeSequenceBuilder {
	
		protected X509IssuerSerialType.X509IssuerSerialTypeBuilder x509IssuerSerial;
		protected String x509SKI;
		protected String x509SubjectName;
		protected String x509Certificate;
		protected String x509CRL;
		protected String anyContents;
		
		@Override
		@RosettaAttribute("x509IssuerSerial")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("x509IssuerSerial")
		public X509IssuerSerialType.X509IssuerSerialTypeBuilder getX509IssuerSerial() {
			return x509IssuerSerial;
		}
		
		@Override
		public X509IssuerSerialType.X509IssuerSerialTypeBuilder getOrCreateX509IssuerSerial() {
			X509IssuerSerialType.X509IssuerSerialTypeBuilder result;
			if (x509IssuerSerial!=null) {
				result = x509IssuerSerial;
			}
			else {
				result = x509IssuerSerial = X509IssuerSerialType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("x509SKI")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("x509SKI")
		public String getX509SKI() {
			return x509SKI;
		}
		
		@Override
		@RosettaAttribute("x509SubjectName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("x509SubjectName")
		public String getX509SubjectName() {
			return x509SubjectName;
		}
		
		@Override
		@RosettaAttribute("x509Certificate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("x509Certificate")
		public String getX509Certificate() {
			return x509Certificate;
		}
		
		@Override
		@RosettaAttribute("x509CRL")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("x509CRL")
		public String getX509CRL() {
			return x509CRL;
		}
		
		@Override
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("anyContents")
		public String getAnyContents() {
			return anyContents;
		}
		
		@RosettaAttribute("x509IssuerSerial")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("x509IssuerSerial")
		@Override
		public X509DataTypeSequence.X509DataTypeSequenceBuilder setX509IssuerSerial(X509IssuerSerialType _x509IssuerSerial) {
			this.x509IssuerSerial = _x509IssuerSerial == null ? null : _x509IssuerSerial.toBuilder();
			return this;
		}
		
		@RosettaAttribute("x509SKI")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("x509SKI")
		@Override
		public X509DataTypeSequence.X509DataTypeSequenceBuilder setX509SKI(String _x509SKI) {
			this.x509SKI = _x509SKI == null ? null : _x509SKI;
			return this;
		}
		
		@RosettaAttribute("x509SubjectName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("x509SubjectName")
		@Override
		public X509DataTypeSequence.X509DataTypeSequenceBuilder setX509SubjectName(String _x509SubjectName) {
			this.x509SubjectName = _x509SubjectName == null ? null : _x509SubjectName;
			return this;
		}
		
		@RosettaAttribute("x509Certificate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("x509Certificate")
		@Override
		public X509DataTypeSequence.X509DataTypeSequenceBuilder setX509Certificate(String _x509Certificate) {
			this.x509Certificate = _x509Certificate == null ? null : _x509Certificate;
			return this;
		}
		
		@RosettaAttribute("x509CRL")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("x509CRL")
		@Override
		public X509DataTypeSequence.X509DataTypeSequenceBuilder setX509CRL(String _x509CRL) {
			this.x509CRL = _x509CRL == null ? null : _x509CRL;
			return this;
		}
		
		@RosettaAttribute("anyContents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("anyContents")
		@Override
		public X509DataTypeSequence.X509DataTypeSequenceBuilder setAnyContents(String _anyContents) {
			this.anyContents = _anyContents == null ? null : _anyContents;
			return this;
		}
		
		@Override
		public X509DataTypeSequence build() {
			return new X509DataTypeSequence.X509DataTypeSequenceImpl(this);
		}
		
		@Override
		public X509DataTypeSequence.X509DataTypeSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public X509DataTypeSequence.X509DataTypeSequenceBuilder prune() {
			if (x509IssuerSerial!=null && !x509IssuerSerial.prune().hasData()) x509IssuerSerial = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getX509IssuerSerial()!=null && getX509IssuerSerial().hasData()) return true;
			if (getX509SKI()!=null) return true;
			if (getX509SubjectName()!=null) return true;
			if (getX509Certificate()!=null) return true;
			if (getX509CRL()!=null) return true;
			if (getAnyContents()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public X509DataTypeSequence.X509DataTypeSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			X509DataTypeSequence.X509DataTypeSequenceBuilder o = (X509DataTypeSequence.X509DataTypeSequenceBuilder) other;
			
			merger.mergeRosetta(getX509IssuerSerial(), o.getX509IssuerSerial(), this::setX509IssuerSerial);
			
			merger.mergeBasic(getX509SKI(), o.getX509SKI(), this::setX509SKI);
			merger.mergeBasic(getX509SubjectName(), o.getX509SubjectName(), this::setX509SubjectName);
			merger.mergeBasic(getX509Certificate(), o.getX509Certificate(), this::setX509Certificate);
			merger.mergeBasic(getX509CRL(), o.getX509CRL(), this::setX509CRL);
			merger.mergeBasic(getAnyContents(), o.getAnyContents(), this::setAnyContents);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			X509DataTypeSequence _that = getType().cast(o);
		
			if (!Objects.equals(x509IssuerSerial, _that.getX509IssuerSerial())) return false;
			if (!Objects.equals(x509SKI, _that.getX509SKI())) return false;
			if (!Objects.equals(x509SubjectName, _that.getX509SubjectName())) return false;
			if (!Objects.equals(x509Certificate, _that.getX509Certificate())) return false;
			if (!Objects.equals(x509CRL, _that.getX509CRL())) return false;
			if (!Objects.equals(anyContents, _that.getAnyContents())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (x509IssuerSerial != null ? x509IssuerSerial.hashCode() : 0);
			_result = 31 * _result + (x509SKI != null ? x509SKI.hashCode() : 0);
			_result = 31 * _result + (x509SubjectName != null ? x509SubjectName.hashCode() : 0);
			_result = 31 * _result + (x509Certificate != null ? x509Certificate.hashCode() : 0);
			_result = 31 * _result + (x509CRL != null ? x509CRL.hashCode() : 0);
			_result = 31 * _result + (anyContents != null ? anyContents.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "X509DataTypeSequenceBuilder {" +
				"x509IssuerSerial=" + this.x509IssuerSerial + ", " +
				"x509SKI=" + this.x509SKI + ", " +
				"x509SubjectName=" + this.x509SubjectName + ", " +
				"x509Certificate=" + this.x509Certificate + ", " +
				"x509CRL=" + this.x509CRL + ", " +
				"anyContents=" + this.anyContents +
			'}';
		}
	}
}
