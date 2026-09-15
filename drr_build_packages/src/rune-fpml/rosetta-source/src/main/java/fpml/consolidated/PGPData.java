package fpml.consolidated;

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
import fpml.consolidated.meta.PGPDataMeta;
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
@RosettaDataType(value="PGPData", builder=PGPData.PGPDataBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PGPData", model="fpml", builder=PGPData.PGPDataBuilderImpl.class, version="2.1.1")
public interface PGPData extends PGPDataType {

	PGPDataMeta metaData = new PGPDataMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	PGPData build();
	
	PGPData.PGPDataBuilder toBuilder();
	
	static PGPData.PGPDataBuilder builder() {
		return new PGPData.PGPDataBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PGPData> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PGPData> getType() {
		return PGPData.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("pgpKeyID"), String.class, getPgpKeyID(), this);
		processor.processBasic(path.newSubPath("pgpKeyPacket"), String.class, getPgpKeyPacket(), this);
		processor.processBasic(path.newSubPath("anyContents0"), String.class, getAnyContents0(), this);
		processor.processBasic(path.newSubPath("anyContents1"), String.class, getAnyContents1(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PGPDataBuilder extends PGPData, PGPDataType.PGPDataTypeBuilder {
		@Override
		PGPData.PGPDataBuilder setPgpKeyID(String pgpKeyID);
		@Override
		PGPData.PGPDataBuilder setPgpKeyPacket(String pgpKeyPacket);
		@Override
		PGPData.PGPDataBuilder addAnyContents0(String anyContents0);
		@Override
		PGPData.PGPDataBuilder addAnyContents0(String anyContents0, int idx);
		@Override
		PGPData.PGPDataBuilder addAnyContents0(List<String> anyContents0);
		@Override
		PGPData.PGPDataBuilder setAnyContents0(List<String> anyContents0);
		@Override
		PGPData.PGPDataBuilder addAnyContents1(String anyContents1);
		@Override
		PGPData.PGPDataBuilder addAnyContents1(String anyContents1, int idx);
		@Override
		PGPData.PGPDataBuilder addAnyContents1(List<String> anyContents1);
		@Override
		PGPData.PGPDataBuilder setAnyContents1(List<String> anyContents1);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("pgpKeyID"), String.class, getPgpKeyID(), this);
			processor.processBasic(path.newSubPath("pgpKeyPacket"), String.class, getPgpKeyPacket(), this);
			processor.processBasic(path.newSubPath("anyContents0"), String.class, getAnyContents0(), this);
			processor.processBasic(path.newSubPath("anyContents1"), String.class, getAnyContents1(), this);
		}
		

		PGPData.PGPDataBuilder prune();
	}

	/*********************** Immutable Implementation of PGPData  ***********************/
	class PGPDataImpl extends PGPDataType.PGPDataTypeImpl implements PGPData {
		
		protected PGPDataImpl(PGPData.PGPDataBuilder builder) {
			super(builder);
		}
		
		@Override
		public PGPData build() {
			return this;
		}
		
		@Override
		public PGPData.PGPDataBuilder toBuilder() {
			PGPData.PGPDataBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PGPData.PGPDataBuilder builder) {
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
			return "PGPData {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of PGPData  ***********************/
	class PGPDataBuilderImpl extends PGPDataType.PGPDataTypeBuilderImpl implements PGPData.PGPDataBuilder {
	
		
		@RosettaAttribute("pgpKeyID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pgpKeyID")
		@Override
		public PGPData.PGPDataBuilder setPgpKeyID(String _pgpKeyID) {
			this.pgpKeyID = _pgpKeyID == null ? null : _pgpKeyID;
			return this;
		}
		
		@RosettaAttribute("pgpKeyPacket")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pgpKeyPacket")
		@Override
		public PGPData.PGPDataBuilder setPgpKeyPacket(String _pgpKeyPacket) {
			this.pgpKeyPacket = _pgpKeyPacket == null ? null : _pgpKeyPacket;
			return this;
		}
		
		@RosettaAttribute("anyContents0")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("anyContents0")
		@Override
		public PGPData.PGPDataBuilder addAnyContents0(String _anyContents0) {
			if (_anyContents0 != null) {
				this.anyContents0.add(_anyContents0);
			}
			return this;
		}
		
		@Override
		public PGPData.PGPDataBuilder addAnyContents0(String _anyContents0, int idx) {
			getIndex(this.anyContents0, idx, () -> _anyContents0);
			return this;
		}
		
		@Override
		public PGPData.PGPDataBuilder addAnyContents0(List<String> anyContents0s) {
			if (anyContents0s != null) {
				for (final String toAdd : anyContents0s) {
					this.anyContents0.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("anyContents0")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("anyContents0")
		@Override
		public PGPData.PGPDataBuilder setAnyContents0(List<String> anyContents0s) {
			if (anyContents0s == null) {
				this.anyContents0 = new ArrayList<>();
			} else {
				this.anyContents0 = anyContents0s.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("anyContents1")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("anyContents1")
		@Override
		public PGPData.PGPDataBuilder addAnyContents1(String _anyContents1) {
			if (_anyContents1 != null) {
				this.anyContents1.add(_anyContents1);
			}
			return this;
		}
		
		@Override
		public PGPData.PGPDataBuilder addAnyContents1(String _anyContents1, int idx) {
			getIndex(this.anyContents1, idx, () -> _anyContents1);
			return this;
		}
		
		@Override
		public PGPData.PGPDataBuilder addAnyContents1(List<String> anyContents1s) {
			if (anyContents1s != null) {
				for (final String toAdd : anyContents1s) {
					this.anyContents1.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("anyContents1")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("anyContents1")
		@Override
		public PGPData.PGPDataBuilder setAnyContents1(List<String> anyContents1s) {
			if (anyContents1s == null) {
				this.anyContents1 = new ArrayList<>();
			} else {
				this.anyContents1 = anyContents1s.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PGPData build() {
			return new PGPData.PGPDataImpl(this);
		}
		
		@Override
		public PGPData.PGPDataBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PGPData.PGPDataBuilder prune() {
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
		public PGPData.PGPDataBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			PGPData.PGPDataBuilder o = (PGPData.PGPDataBuilder) other;
			
			
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
			return "PGPDataBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
